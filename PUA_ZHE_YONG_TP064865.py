#PUA ZHE YONG
#TP064865

import datetime

# variables for main logic
homepage = True
printhomepage = True
patientregistration = False
vaccine = None
vaccine_administration = False
printrecord = False
printstatistics = False
printamend = True
verifyage = True
verifyvaccine = True
verifycontact = True


#for new user registration
def registration_user():
    registraton_user_list = []
    print("\nRegistration of new user")
    print("====================================")
    userid = input("Please enter new User ID: ")
    userpw = input("Please enter new password: ")

    #saving user details as lists
    registraton_user_list.append(userid)
    registraton_user_list.append(userpw)

    userregister = ','.join(registraton_user_list)
    userregister = userregister + '\n'

    fhandle = open('login.txt', 'a')
    fhandle.write(userregister)
    fhandle.close()

    print("User ID and Password recorded.")

    return

#for login into the system
def login_user():
    printlogin_user = True
    printverify = True
    flg = 0
    while printlogin_user == True:
        while printverify == True:
            print("\nWelcome to COVID-19 Vaccination Record Management System")
            print("=====================================================================")
            print("1. Continue")
            print("2. Exit")
            print("=====================================================================")
            option = input("Please enter an option: ")

            if option == '1':
                userid = input("Please enter User ID: ")
                userpw = input("Please enter password: ")
                
                fhandle = open('login.txt')
                verify = fhandle.readlines()
                fhandle.close()
                
                #extracting credentials from login.txt
                thatspecificuser = list()
                for details in verify:
                    details = details.split(',')
                    if details[0] == userid:
                        thatspecificuser.append(details[0])
                        loginpw = details[1]
                        loginpw = loginpw[:-1]
                        thatspecificuser.append(loginpw)
                
                #verification of login id and pw
                if len(thatspecificuser) == 0:
                    print('User does not exist\n')
                else:
                    if userpw != loginpw:
                        print('Password incorrect! Please try again!\n')
                        break
                    else:
                        printverify = False
                        printlogin_user = False
                        flg = 1
                        return flg 
            elif option == '2':
                exit() 
            else:
                print("Wrong input. Please try again.")   
                break

#Main logic
if login_user() == 1:
    while homepage == True:
        while printhomepage == True:
            print("\nWelcome to COVID-19 Vaccination Record Management System")
            print("=======================================================================")
            print("1. New Patient Registration")
            print("2. Vaccine Administration")
            print("3. Patient Record and Vaccination Status")
            print("4. Statistics")
            print("5. Registration New User")
            print("6. Exit")
            print("=======================================================================")
        
            option = input("Please select your option: ")
            
            #selection of options 
            if option == '1':
                print("\n")
                printhomepage = False
                patientregistration = True
            elif option == '2':
                print("\n")
                printhomepage = False
                vaccine_administration = True
            elif option == '3':
                print("\n")
                printhomepage = False
                printrecord = True
            elif option == '4':
                print("\n")
                printhomepage = False
                printstatistics = True
            elif option == '5':
                printhomepage = False
                registration_user()
                printhomepage = True
            elif option == '6':
                exit()
            else:
                print("Invalid input on options. Please try again!\n")
                break
            
        #New Patient Registration
        while patientregistration == True:
            registration_list = []   
            print("New Patient Registration System")
            print("=================================================================\n")
            
            #Vaccination Centre
            vc = input("Please enter vaccination centre (VC1 / VC2): ") 
            if vc != 'VC1' and vc != 'VC2':
                print("Wrong Input. Only VC1 or VC2 allowed. Please Try Again\n")
                break 
            
            #Name and verifying input
            name = input("Please enter patient's name: ")
            if ' ' in name:
                partofname = list()
                namesplit = name.split()
                for namewithspace in namesplit:
                    partofname.append(namewithspace.isalpha())
                if False in partofname:
                    print("Wrong Input. Name contain digit or symbol. Please Try Again\n")
                    break
            else:
                if name.isalpha() == False:
                    print("Wrong Input. Name contain digit or symbol. Please Try Again\n")
                    break
            verifyage = True
            
            #Age and verifying age
            while verifyage == True:
                age = input("Please enter patient's age: ")
                if age.isdigit() == False or int (age) < 12:
                    print("Wrong Input or patient is underage. Please try again.\n")
                else:
                    verifyage = False
            verifyvaccine = True
            
            #To show vaccine options based on age group
            age = int(age)
            print("Vaccine options available:")
            print("==================================================================")
            print('{:<10} {:<10} {:<15} {:<15}'.format('Vaccine', 'Doses', 'Interval', 'Age Group'))
            if age >= 12 and age <= 45:
                print('{:<10} {:<10} {:<15} {:<15}'.format('CZ', '2 Doses', '21 days', '12 - 45'))
            if age >= 12:
                print('{:<10} {:<10} {:<15} {:<15}'.format('AF', '2 Doses', '14 days', '12 and above'))
                print('{:<10} {:<10} {:<15} {:<15}'.format('DM', '2 Doses', '21 days', '12 and above'))
            if age >= 18:
                print('{:<10} {:<10} {:<15} {:<15}'.format('BV', '2 Doses', '21 days', '18 and above'))
                print('{:<10} {:<10} {:<15} {:<15}'.format('EC', '1 Dose', '-', '18 and above'))

            #Selecting vaccine and verifying age group to vaccine type
            while verifyvaccine == True:    
                verifyvaccine2 = True
                while verifyvaccine2 == True:    
                    vaccine = input("Please select a vaccine: ")

                    if vaccine == 'AF' or vaccine == 'DM':
                        age_limit = 12
                        if age < age_limit:
                            print("Age does not suit to the vaccine. Please try again.")
                            break
                        else:
                            verifyvaccine2 = False
                            verifyvaccine = False
                            break
                    elif vaccine == 'BV' or vaccine == 'EC':
                        age_limit = 18
                        if age < age_limit:
                            print("Age does not suit to the vaccine. Please try again.")
                            break
                        else:
                            verifyvaccine2 = False
                            verifyvaccine = False
                            break
                    elif vaccine == 'CZ':
                        if age < 12 or age > 45:
                            print("Age does not suit to the vaccine. Please try again.")
                            break
                        else:
                            verifyvaccine2 = False
                            verifyvaccine = False
                            break
                    elif vaccine != 'AF' or vaccine != 'DM' or vaccine != 'BV' or vaccine != 'EC' or vaccine != 'CZ':
                        print("Vaccine doesn't exist. PLease try again.")
                        break
                    else:
                        verifyvaccine2 = False
                        verifyvaccine = False
                        break
                verifycontact = True
                verifycontact2 = True
            
            #Receiving patient's contact number and verify for Malaysian phone number format
            while verifycontact == True: 
                verifycontact2 = True
                while verifycontact2 == True:
                    contact = input("Please enter patient's number: ")
                    
                    check_contact = contact[:2]
                    splitnumber = check_contact
                    splitnumber = check_contact.split()

                    if splitnumber[0] == "01" and 10 <= len(contact) < 12 :
                        contact = "+6" + contact
                        verifycontact2 = False
                        verifycontact = False
                    else:
                        print ("Invalid input. Please type again.")
                        break

            print("\nPatient details recorded.")
            #Patient ID generation
            fhandle = open('patients.txt')
            number = fhandle.readlines()
            fhandle.close()

            number = len(number)
            number += 1
            number = str(number)
            patientid = "PID" + number

            #storing credentials of patient
            registration_list.append(patientid)
            registration_list.append(vc)
            registration_list.append(name)
            age = str(age)
            registration_list.append(age)
            registration_list.append(contact)
            registration_list.append(vaccine)

            record = ','.join(registration_list)
            record = record + "\n"

            fhandle = open('patients.txt', 'a')
            fhandle.write(record)
            fhandle.close() 

            input("\nPress Enter to Continue")

            patientregistration = False
            printhomepage = True

        #Vaccine administration 
        while vaccine_administration == True:
            administration_list = []
            flg1 = 0
            flg2 = 0
            print("\nVaccine Administration System")
            print("=============================================================\n")
            patientid = input("Please enter patient ID: ")
            dose_number = input ("Please input dose number (D1 or D2): ")

            #Extract patient's credentials and verify vaccine type
            fhandle = open('patients.txt')
            check = fhandle.readlines()
            fhandle.close()

            #Verify patient ID and exclude PID
            check_patientid = patientid[3:]
            check_patientid = int (check_patientid)
            if check_patientid > len(check):
                print("Patient ID not found. Please try again.")
                break
            check_patientid -= 1
            line = check[check_patientid]
            line = line.split(",")


            vaccinecode = line[5]
            vaccinecode = vaccinecode[:-1]
            vccentre = line[1]
            tdydate = datetime.date.today()

            #Notify the patient on date of D2 if applicable
            fhandle = open('vaccination.txt')
            double_check = fhandle.readlines()
            fhandle.close()

            #Verify patient status to ensure no repeating administration of D1 or D2 doses
            verifypatientid_list = []

            for verifypatientid in double_check:
                    verifypatientid = verifypatientid.split(',')
                    if verifypatientid[0] == patientid:
                        verifypatientid_list.append(verifypatientid[0])
                        dose1 = verifypatientid[3]
                        dose2 = verifypatientid[5]
                        verifypatientid_list.append(dose1)
                        verifypatientid_list.append(dose2) 
            #Date of D2 if applicable
            if len(verifypatientid_list) == 0:
                if dose_number == "D1":
                    if vaccinecode == 'AF':
                        secdose = tdydate + datetime.timedelta(days = 14)
                        print("\nD2 is", secdose)
                    elif vaccinecode == 'BV' or vaccinecode == 'CZ':
                        secdose = tdydate + datetime.timedelta(days = 21)
                        print("\nD2 is", secdose)
                    elif vaccinecode == 'DM': 
                        secdose = tdydate + datetime.timedelta(days = 28)
                        print("\nD2 is", secdose)
                    elif vaccinecode == 'EC':
                        print("\nCongratulation! Your vaccination fully completed.")
                if dose_number == "D2":
                    print("Patient is not vaccinated with dose 1 yet. Please try again.")
                    break
            
            elif verifypatientid_list[0] == patientid and dose2 == "D2":
                print("Patient is fully vaccinated. Please try again.")
                vaccine_administration = False
                printhomepage = True
                break

            elif verifypatientid[0] == patientid and dose2 == "NA\n":
                print("Patient is fully vaccinated. Please try again.")
                vaccine_administration = False
                printhomepage = True
                break
            
            elif verifypatientid_list[0] == patientid and dose1 == "D1": 
                if dose_number == "D1":
                    print("Patient is vaccinated with dose 1. Please Try Again.")
                    break
                #For D2 patients, to verify their date for second dose
   
                if dose_number == "D2" and vaccinecode != 'EC':
                    fhandle = open('vaccination.txt')
                    check = fhandle.readlines()
                    fhandle.close()
                    for line_D2 in check:
                        line_D2 = line_D2.split(',')
                        if line_D2[0] == patientid: 
                            D2date = line_D2[6]
                            D2date = D2date[:-1]   
                            if line_D2[4] >= D2date: 
                                print("\nCongratulation! Your vaccination is fully completed")
                                flg1 = 1
                            elif line_D2[4] < D2date: 
                                print("\nYour D2 vaccination date have not reached. Please come at the exact date.")
                                flg1 = 0
            
            input("Press Enter to Continue")                 

            #Recording new info into vaccination.txt
            if dose_number == "D1":
                tdydate = str(tdydate)
                administration_list.append(patientid)
                administration_list.append(vccentre)
                administration_list.append(vaccinecode)
                administration_list.append(dose_number)
                administration_list.append(tdydate)
                if vaccinecode != "EC":    
                    administration_list.append("-")
                    secdose = str(secdose)
                    administration_list.append(secdose)
                else:
                    administration_list.append("NA")

                record =','.join(administration_list)
                record = record + "\n"
                
                fhandle = open('vaccination.txt', 'a' )
                fhandle.write(record)
                fhandle.close()

            #Rewrite for D2 patients in Vaccination.txt
            if dose_number == "D2" and flg1 == 1:
                fhandle = open('vaccination.txt', 'r')
                oldlist = fhandle.readlines()
                fhandle.close()
                
                newlist = list()
            #Rewrite patients D2 status
                for line in oldlist:
                    line = line.split(",")
                    if line[0] == patientid:
                        lineD2 = line      
                        lineD2[5] = "D2"
                for line in oldlist:
                    line = line.split(",")
                    if line[0] == patientid:
                        line = lineD2
                        line = ','.join(line)
                        newlist.append(line)

            #Rewrite patients status and replacing old lists
                fhandle = open('vaccination.txt', 'w+')
                for checking in oldlist:
                    checking = checking.split(',')
                    if checking[0] != patientid:
                        checking = ','.join(checking)
                        fhandle.writelines(checking)
                fhandle.close()

                fhandle = open('vaccination.txt', 'a')
                fhandle.writelines(newlist)
                fhandle.close()

            printhomepage = True
            vaccine_administration = False

        #Patient Record and Vaccination Status System   
        while printrecord == True:
            print("Patient Record and Vaccination Status System")
            print("=====================================================================\n")
            patient_id = input("Please enter Patient ID: ")

            status_list = []
            record_list = []

            #Retrieve credentials of patients to show patients record
            fhandle1 = open('patients.txt')
            check1 = fhandle1.readlines()
            fhandle1.close()

            for verifyrecord in check1:
                verifyrecord = verifyrecord.split(',')
                if verifyrecord[0] == patient_id:
                    verifyrecord = ','.join(verifyrecord)
                    record_list.append(verifyrecord)

            if len(record_list) == 0:
                print("Patient Record: NONE")
            else:
                for split_record in check1:
                    split_record = split_record.split('.')
                    for patient_record in split_record:
                        patient_record = patient_record.split(',')
                        if patient_record[0] == patient_id:
                            print('{:<6} {:<7} {:<20} {:<6} {:<14} {:<10}'.format('ID', 'Centre', 'Name', 'Age', 'Contact', 'Type'))
                            print('{:<6} {:<7} {:<20} {:<6} {:<14} {:<10}'.format(patient_record[0], patient_record[1], patient_record[2], patient_record[3], patient_record[4], patient_record[5]))

            #Retrieve credentials of patients to show patients vaccination status
            fhandle = open('vaccination.txt')
            check = fhandle.readlines()
            fhandle.close()

            for details in check:
                details = details.split(',')
                if details[0] == patient_id:
                    details = ','.join(details)
                    status_list.append(details)
            
            if len(status_list) == 0:
                print('Patient Status: NEW')
            else:
                for specific in status_list:
                    specific = specific.split(',')
                if specific[2] != "EC":
                    if specific[5] == '-':
                        print('{:<6} {:<7} {:<6} {:<10} {:<12} {:<10} {:<12}'.format('ID', 'Centre', 'Type', 'D1', 'D1 Date', 'D2', 'D2 Date'))
                        print('{:<6} {:<7} {:<6} {:<10} {:<12} {:<10} {:<12}'.format(specific[0], specific[1], specific[2], 'Completed', specific[4], 'Waiting', specific[6]))
                    else:
                        print('{:<6} {:<7} {:<6} {:<10} {:<12} {:<10} {:<12}'.format('ID', 'Centre', 'Type', 'D1', 'D1 Date', 'D2', 'D2 Date'))
                        print('{:<6} {:<7} {:<6} {:<10} {:<12} {:<10} {:<12}'.format(specific[0], specific[1], specific[2], 'Completed', specific[4], 'Completed', specific[6]))
                else: 
                    print('{:<6} {:<7} {:<6} {:<10} {:<12}'.format('ID', 'Centre', 'Type', 'D1', 'D1 Date'))
                    print('{:<6} {:<7} {:<6} {:<10} {:<12}'.format(specific[0], specific[1], specific[2], 'Completed', specific[4]))
            
            input("Press Enter to continue\n")

            printrecord = False
            printhomepage = True

        #Statistics  
        while printstatistics == True:
            print("Statistics System")
            print("=========================================================\n")
            
            statistics_list = list()
            totalvc1 = 0
            totalvc2 = 0
            totalwaitingvc1 = 0
            totalcompletedvc1 = 0
            totalwaitingvc2 = 0
            totalcompletedvc2 = 0
            
            #Calculate the number of patients registered in both VC and vaccine completetion
            fhandle = open('vaccination.txt')
            check = fhandle.readlines()
            fhandle.close()

            #Number of patients in each VC
            for statistics_list in check:
                statistics_list = statistics_list.split(',')
                if statistics_list[1] == "VC1":
                    totalvc1 += 1
                else:
                    totalvc2 += 1
            
            #Number of patients that completed or not completed vaccination at both VC
                if statistics_list[1] == "VC1":
                    if statistics_list[2] != "EC": 
                        if statistics_list[5] == '-':
                            totalwaitingvc1 += 1
                        else:
                            totalcompletedvc1 += 1
                    else:
                        totalcompletedvc1 += 1
                else:
                    if statistics_list[2] != "EC": 
                        if statistics_list[5] == '-':
                            totalwaitingvc2 += 1
                        else:
                            totalcompletedvc2 += 1
                    else:
                        totalcompletedvc2 += 1
            
            print('{:<5} {:<17} {:<12} {:<10}'.format('VC', 'No. of patients','Waiting D2','Completed'))
            print('{:<5} {:<17} {:<12} {:<10}'.format('VC1', totalvc1 , totalwaitingvc1, totalcompletedvc1))
            print('{:<5} {:<17} {:<12} {:<10}'.format('VC2', totalvc2 , totalwaitingvc2, totalcompletedvc2))

            input("Press Enter to Continue")

            printstatistics = False
            printhomepage = True       


