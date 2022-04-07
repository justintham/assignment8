from flask import Flask, render_template, request, url_for
from pymysql import connections
import os
import boto3
from config import *
from botocore.client import Config

app = Flask(__name__,template_folder='templates')

bucket = custombucket
region = customregion
cloud_domain = cloudfront

db_conn = connections.Connection(
    host=customhost,
    port=3306,
    user=customuser,
    password=custompass,
    db=customdb

)
output = {}
table = 'employee'                                                          #NO IMPORTANT?


@app.route("/", methods=['GET', 'POST'])
def home():
    return render_template('home.html')

@app.route("/about", methods=['GET', 'POST'])
def aboutus():
     return render_template('AboutUs.html')

@app.route("/contact", methods=['GET', 'POST'])
def contactus():
     return render_template('ContactUs.html')


@app.route("/empDatabase", methods=['GET', 'POST'])
def employeeDatabase():
    return render_template('EmployeeSystem.html')

@app.route("/empDatabase1", methods=['GET', 'POST'])
def attendanceDatabase():
    return render_template('AttendanceSystem.html')

@app.route("/empDatabase2", methods=['GET', 'POST'])
def queryDatabase():
    return render_template('query.html')


@app.route("/addemp", methods=['POST'])
def AddEmp():
    emp_image_file = request.files['emp_image_file']
    employee_name = request.form['employee_name']
    address = request.form['address']
    email_address = request.form['email_address']
    phone_number = request.form['phone_number']
    emp_id = request.form['emp_id']
    job_role = request.form['job_role']
    salary = request.form['salary']

    insert_sql = "INSERT INTO employee VALUES (%s, %s, %s, %s, %s, %s, %s)"
    cursor = db_conn.cursor()

    if emp_image_file.filename == "":
        return "Please select a file"

    try:

        cursor.execute(insert_sql, (employee_name, address, email_address, phone_number, emp_id, job_role, salary))
        db_conn.commit()
        # Uplaod image file in S3 #
        emp_image_file_name_in_s3 = "emp-id-" + str(emp_id) + ".png"
        s3 = boto3.resource('s3')
        number_of_rows = cursor.execute("SELECT * FROM employee")
        scientist_count = cursor.execute("SELECT * FROM employee WHERE job_role = 'Data Scientist'")
        engineering_count = cursor.execute("SELECT *  FROM employee WHERE job_role = 'Software Engineering'")
        hr_count = cursor.execute("SELECT * FROM employee WHERE job_role = 'Human Resource'")
        #image_url = "https://"+bucket+".s3.amazonaws.com/"+emp_image_file_name_in_s3
        image_url = "https://"+cloud_domain+"/"+emp_image_file_name_in_s3


        try:
            print("Data inserted in MySQL RDS... uploading image to S3...")
            s3.Bucket(custombucket).put_object(Key=emp_image_file_name_in_s3, Body=emp_image_file)
            s3_object = s3.Object(bucket, emp_image_file_name_in_s3)
            s3_object.metadata.update({'id':'image/png'})
            s3_object.copy_from(CopySource={'Bucket':bucket, 'Key':emp_image_file_name_in_s3}, Metadata=s3_object.metadata, MetadataDirective='REPLACE')
            bucket_location = boto3.client('s3').get_bucket_location(Bucket=custombucket)
            s3_location = (bucket_location['LocationConstraint'])

            if s3_location is None:
                s3_location = ''
            else:
                s3_location = '-' + s3_location

            object_url = "https://s3{0}.amazonaws.com/{1}/{2}".format(
                s3_location,
                custombucket,
                emp_image_file_name_in_s3)


        except Exception as e:
            return str(e)

    finally:
        cursor.close()

    print("all modification done...")
    return render_template('OutputEmployeeSystem.html', employee_id = emp_id, name=employee_name, jobrole=job_role,month_salary=salary, number_of_rows=number_of_rows, scientist_count = scientist_count, engineering_count = engineering_count, hr_count = hr_count, image_url = image_url)




@app.route("/addemp1", methods=['POST'])
def AddEmp1():
    emp_id = request.form['emp_id']
    first_name = request.form['first_name']
    date = request.form['currentDate1']
    time = request.form['currentTime1']
 

    insert_sql = "INSERT INTO attendance VALUES (%s, %s, %s, %s)"             #CHANGE TABLE NAME?
    cursor = db_conn.cursor()

    cursor.execute(insert_sql, (emp_id, first_name, date, time))
    db_conn.commit()
    emp_num = emp_id
    emp_name = first_name
    date_now = date
    timenow = time

    cursor.close()

    print("all modification done...")
    return render_template('OutputAttendanceSystem.html', name=emp_name, id = emp_num, date_1 = date_now, time_1 =timenow )

@app.route("/queryemp", methods=['POST'])
def QueryEmp():
    try:
        emp_id2 = request.form['emp_id']
        emp_name2 =''
        job_role2 =''
        salary2 =''
    
        if emp_id2  == "":
            return "Please type number"

        query_employee = "SELECT employee_name,job_role,salary FROM employee WHERE emp_id = %s"
        cursor = db_conn.cursor()
        cursor.execute(query_employee,(emp_id2))
        db_conn.commit()
        # get all records
        records = cursor.fetchall()

        for row in records:
 
            emp_name2=row[0]
            job_role2=row[1]
            salary2=row[2]
        cursor.close()

    except Exception as e:
        return str(e)

    print("all modification done...")
    return render_template('queryOutput.html', id=emp_id2, name = emp_name2, job_role = job_role2,salary =salary2)    



if __name__ == '__main__':
    app.run(host='0.0.0.0', port=80, debug=True)