#Pua Zhe Yong
#TP064865

import <- read.csv(file = "/Users/yongpua/Desktop/APU/PDFA/employee_attrition.csv", header = TRUE, sep = "," )

dataset <- import

library(dplyr)
library(ggplot2)

#remove duplicates on active employees
clean_active <- filter(dataset, recorddate_key == '12/31/2015 0:00')
clean_active

#filter terminated employees
clean_terminated <- filter(dataset, STATUS == 'TERMINATED')
clean_terminated


#Q1 - Why employees resigned under 5 years of service
#Filter those that resigned under 5 years of servcice
clean_resign <- filter(clean_terminated, termreason_desc == "Resignaton")
clean_resign

clean_under5 <- filter(clean_resign, length_of_service <= 5)

#A1 - Find out number of employees under 5 years of service that resigned
#Create a new table to insert required information
table1 <- table(clean_under5$length_of_service, clean_under5$termreason_desc)
table1
rownames(table1) <- c('0 years','1 year','2 years','3 years','4 years','5 years')
colnames(table1) <- c("termreason_desc")
new_table1 <- as.data.frame.matrix(table1)
new_table1['length_of_service'] <- c('0 years','1 year','2 years','3 years','4 years','5 years')

#Plotting Bar Graph  
A1_plot <- ggplot(new_table1, aes(x = length_of_service, y = termreason_desc)) + 
  geom_bar(stat = 'identity', col='blue', fill='black') +
  labs(title = "Total number of employees resigned under 5 years of service", 
       x = "Length of Service", y = "Number of Employees Resigned")
A1_plot

#A2- Find out which position that are resigned the most within 5 years of service
table2 <- table(clean_under5$length_of_service, clean_under5$job_title)
colnames(table2) <- c("Baker","Cashier", "Dairy_Person", "Meat_Cutter", "Produce_Clerk","Shelf_Stocker")
table2
new_table2 <- as.data.frame.matrix(table2)
new_table2['length_of_service'] <- c('0 years','1 year','2 years','3 years','4 years','5 years')

A2_plot <- ggplot(new_table2, aes(color = Position)) +
geom_line(data = new_table2, mapping = aes(x = length_of_service, y = Baker, group = 1, colour = "Baker")) + 
  geom_point(data = new_table2, mapping = aes(x = length_of_service, y = Baker, group = 1, colour = "Baker")) +
  
geom_line(data = new_table2, mapping = aes(x = length_of_service, y = Cashier, group = 1, colour = "Cashier"))+
  geom_point(data = new_table2, mapping = aes(x = length_of_service, y = Cashier, group = 1, colour = "Cashier"))+

geom_line(data = new_table2, mapping = aes(x = length_of_service, y = Dairy_Person, group = 1, colour = "Dairy Person")) + 
  geom_point(data = new_table2, mapping = aes(x = length_of_service, y = Dairy_Person, group = 1, colour = "Dairy Person")) + 

geom_line(data = new_table2, mapping = aes(x = length_of_service, y = Meat_Cutter, group = 1, colour = "Meat Cutter")) + 
  geom_point(data = new_table2, mapping = aes(x = length_of_service, y = Meat_Cutter, group = 1, colour = "Meat Cutter")) + 

geom_line(data = new_table2, mapping = aes(x = length_of_service, y = Produce_Clerk, group = 1, colour = "Produce Clerk")) + 
  geom_point(data = new_table2, mapping = aes(x = length_of_service, y = Produce_Clerk, group = 1, colour = "Produce Clerk")) + 
  
geom_line(data = new_table2, mapping = aes(x = length_of_service, y = Shelf_Stocker, group = 1, colour ="Shelf Stocker")) + 
  geom_point(data = new_table2, mapping = aes(x = length_of_service, y = Shelf_Stocker, group = 1, colour ="Shelf Stocker")) + theme_bw() +
  labs(title ="Number of employees from different position that resigned under 5 years of service ", x= "Length of service", y = "Number of employees")
A2_plot

#A3 - Find out the relationship between age and position of those resigned under 5 years of service
table3 <- table(clean_under5$age, clean_under5$job_title)
colnames(table3) <- c("Baker","Cashier", "Dairy_Person", "Meat_Cutter", "Produce_Clerk","Shelf_Stocker")
table3
new_table3 <- as.data.frame.matrix(table3)
new_table3['age'] <- c(19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35)

A3_plot <- ggplot(new_table3, aes (color = Position)) +
  geom_freqpoly(data = new_table3, mapping = aes(x = age, y = Baker, colour = "Baker"), stat = 'identity')+
  geom_freqpoly(data = new_table3, mapping = aes(x = age, y = Cashier, colour = "Cashier"), stat = 'identity')+
  geom_freqpoly(data = new_table3, mapping = aes(x = age, y = Dairy_Person, colour = "Dairy Person"), stat = 'identity')+
  geom_freqpoly(data = new_table3, mapping = aes(x = age, y = Meat_Cutter, colour = "Meat Cutter"), stat = 'identity')+
  geom_freqpoly(data = new_table3, mapping = aes(x = age, y = Produce_Clerk, colour = "Produce Clerk"), stat = 'identity')+
  geom_freqpoly(data = new_table3, mapping = aes(x = age, y = Shelf_Stocker, colour = "Shelf Stocker"), stat = 'identity') + theme_bw() + 
  labs(title="Relationship between age of employees and their position", x = "Age of employees", y ="Number of employees")
A3_plot

#Q2 - cleaning and transforming the data
clean_2014 <- filter(dataset, recorddate_key == '12/31/2014 0:00')
clean_2014_2 <- filter(clean_2014, STATUS == 'ACTIVE')

#A1 - Find the total number of employees between 2 years
group2014 <- nrow(clean_2014_2)
group2015 <- nrow(clean_active)

new_table1_2 <- data.frame(group2014, group2015)
new_table1_2

#plotting bar graph
A1Q2_plot <- ggplot(new_table1_2)+
  geom_bar(data = new_table1_2, mapping = aes(x = "2014", y = group2014),stat = 'identity', fill = "blue", col = "black")+
  geom_bar(data = new_table1_2, mapping = aes(x = "2015", y = group2015),stat = 'identity', fill = "light blue", col ="black") + 
  geom_text(x = "2014", y = 5100, label = group2014)+ geom_text(x = "2015", y = 5100, label = group2015,)+
  theme_bw()+
  labs(title = "Number of employees between 2014 and 2015", x= "Year", y="Number of employees")
A1Q2_plot

#A2 - Find the numbers of terminated employees between 2014 and 2015
#Data cleaning and transformation
terminated2014 <- filter(clean_terminated, STATUS_YEAR == "2014")
terminated2015 <- filter(clean_terminated, STATUS_YEAR == "2015")

group2014_2 <- nrow(terminated2014)
group2015_2 <- nrow(terminated2015)

new_table2_2 <- data.frame(group2014_2, group2015_2)
new_table2_2

#plotting bar graph
A2Q2_plot <- ggplot(new_table2_2)+
  geom_bar(data = new_table2_2, mapping = aes(x = "2014", y = group2014_2),stat = 'identity', fill = "pink", col = "black")+
  geom_bar(data = new_table2_2, mapping = aes(x = "2015", y = group2015_2),stat = 'identity', fill = "red", col ="black") + 
  geom_text(x = "2014", y = 260, label = group2014_2)+ geom_text(x = "2015", y = 175, label = group2015_2)+
  theme_bw()+
  labs(title = "Number of terminated employees between 2014 and 2015", x= "Year", y="Number of terminated employees")
A2Q2_plot

#A3 - Find newly hired employees in year 2014 and 2015
#Data cleaning and transformation
serviceyear2014 <- filter(clean_2014_2, length_of_service == "0")
serviceyear2015 <- filter(clean_active, length_of_service == "0")

group2014_3 <- nrow(serviceyear2014)
group2015_3 <- nrow(serviceyear2015)

new_table3_2 <- data.frame(group2014_3, group2015_3)

#Data Visualization, bar plotting
A3Q2_plot <- ggplot(new_table3_2)+
  geom_bar(data = new_table3_2, mapping = aes(x = "2014", y = group2014_3),stat = 'identity', fill = "pink", col = "black")+
  geom_bar(data = new_table3_2, mapping = aes(x = "2015", y = group2015_3),stat = 'identity', fill = "red", col ="black") + 
  geom_text(x = "2014", y = 260, label = group2014_3)+ geom_text(x = "2015", y = 175, label = group2015_3)+
  theme_bw()+
  labs(title = "How many newly hired employees in between 2014 and 2015", x= "Year", y="Number of employees")
A3Q2_plot

#Q3
clean_laidoff <- filter(clean_terminated, termreason_desc == "Layoff")
clean_laidoff

#A1 - Their reason and their type
#Data cleaning & transformation
table1_3 <- table(clean_terminated$termreason_desc, clean_terminated$termtype_desc)
table1_3
new_table1_3 <- as.data.frame.matrix(table1_3)
new_table1_3['Reason'] <- c("Layoff", "Resignation", "Retirement")
new_table1_3

#plotting a bar graph
A1Q3_plot <- ggplot(new_table1_3, aes(color = Type))+
  geom_bar(data = new_table1_3, mapping= aes(x= Reason, y= Involuntary, colour ="Involuntary"), stat = 'identity', fill= "black")+
  geom_bar(data = new_table1_3, mapping= aes(x= Reason, y=Voluntary, colour="Voluntary"), stat = 'identity', fill ="black") + theme_bw() +
  labs(title = "Number of employees that are terminated and their reason/type", x="Reason", y="Number of employees")
A1Q3_plot


#A2 - Find out the age and their position for those that are laid off
#Data Transformation
table2_3 <- table(clean_laidoff$age, clean_laidoff$job_title)
colnames(table2_3) <- c("Baker","Bakery_Manager","Cashier","Customer_Service_Manager","Dairy_Person","Meats_Cutter","Meats_Manager",
                        "Processed_Foods_Manager","Produce_Clerk","Produce_Manager","Shelf_Stocker","Store_Manager")
table2_3
new_table2_3 <- as.data.frame.matrix(table2_3)
new_table2_3['age'] <- c(20:64)
new_table2_3

#plotting line graph
A2Q3_plot <- ggplot(new_table2_3, aes(color = Position))+
  geom_line(data = new_table2_3, aes(x = age, y = Baker, colour = "Baker"), stat = 'identity')+
  geom_line(data = new_table2_3, aes(x = age, y = Bakery_Manager, colour = "Bakery Manager"), stat = 'identity')+
  geom_line(data = new_table2_3, aes(x = age, y = Cashier, colour = "Cashier"), stat = 'identity')+
  geom_line(data = new_table2_3, aes(x = age, y = Customer_Service_Manager, colour = "Customer_Service_Manager"), stat = 'identity')+
  geom_line(data = new_table2_3, aes(x = age, y = Dairy_Person, colour = "Dairy Person"), stat = 'identity')+
  geom_line(data = new_table2_3, aes(x = age, y = Meats_Cutter, colour = "Meats Cutter"), stat = 'identity')+
  geom_line(data = new_table2_3, aes(x = age, y = Meats_Manager, colour = "Meats Manager"), stat = 'identity')+
  geom_line(data = new_table2_3, aes(x = age, y = Processed_Foods_Manager, colour = "Processed Foods Manager"), stat = 'identity')+
  geom_line(data = new_table2_3, aes(x = age, y = Produce_Clerk, colour = "Produce Clerk"), stat = 'identity')+
  geom_line(data = new_table2_3, aes(x = age, y = Produce_Manager, colour = "Produce Manager"), stat = 'identity')+
  geom_line(data = new_table2_3, aes(x = age, y = Shelf_Stocker, colour = "Shelf Stocker"), stat = 'identity')+
  geom_line(data = new_table2_3, aes(x = age, y = Store_Manager, colour = "Store Manager"), stat = 'identity')+ theme_bw()+ 
  labs(title= "Age of the laid off employees compared to their position", x = "Age", y ="Number of the employees")
A2Q3_plot

#A3 - Find the relationship between Length of Service and position of the laid off employees
#Data Transformation
table3_3 <- table(clean_laidoff$length_of_service, clean_laidoff$job_title)
colnames(table3_3) <- c("Baker","Bakery_Manager","Cashier","Customer_Service_Manager","Dairy_Person","Meats_Cutter","Meats_Manager",
                        "Processed_Foods_Manager","Produce_Clerk","Produce_Manager","Shelf_Stocker","Store_Manager")
table3_3
new_table3_3 <- as.data.frame.matrix(table3_3)
new_table3_3['length_of_service'] <- c(1:25)
new_table3_3

#plotting line graph
A3Q3_plot <- ggplot(clean_laidoff, aes(color = Job))+
  geom_line(data = new_table3_3, aes(x = length_of_service, y = Baker, colour = "Baker"), stat = 'identity')+
  geom_line(data = new_table3_3, aes(x = length_of_service, y = Bakery_Manager, colour = "Bakery Manager"), stat = 'identity')+
  geom_line(data = new_table3_3, aes(x = length_of_service, y = Cashier, colour = "Cashier"), stat = 'identity')+
  geom_line(data = new_table3_3, aes(x = length_of_service, y = Customer_Service_Manager, colour = "Customer_Service_Manager"), stat = 'identity')+
  geom_line(data = new_table3_3, aes(x = length_of_service, y = Dairy_Person, colour = "Dairy Person"), stat = 'identity')+
  geom_line(data = new_table3_3, aes(x = length_of_service, y = Meats_Cutter, colour = "Meats Cutter"), stat = 'identity')+
  geom_line(data = new_table3_3, aes(x = length_of_service, y = Meats_Manager, colour = "Meats Manager"), stat = 'identity')+
  geom_line(data = new_table3_3, aes(x = length_of_service, y = Processed_Foods_Manager, colour = "Processed Foods Manager"), stat = 'identity')+
  geom_line(data = new_table3_3, aes(x = length_of_service, y = Produce_Clerk, colour = "Produce Clerk"), stat = 'identity')+
  geom_line(data = new_table3_3, aes(x = length_of_service, y = Produce_Manager, colour = "Produce Manager"), stat = 'identity')+
  geom_line(data = new_table3_3, aes(x = length_of_service, y = Shelf_Stocker, colour = "Shelf Stocker"), stat = 'identity')+
  geom_line(data = new_table3_3, aes(x = length_of_service, y = Store_Manager, colour = "Store Manager"), stat = 'identity')+
  labs(title = "Relationship between length of service of the laid off employees and their position", x = "Length of Service", y = "Number of employees")
A3Q3_plot


#Q4
clean_after10 <- filter(clean_active, length_of_service >= 10)
clean_after10

#A1 - Relationship between their position and those who serviced the company for more than 10 years]
#Data Transformation
table1_4 <- table(clean_after10$length_of_service, clean_after10$job_title)
colnames(table1_4) <- c("Baker","Bakery_Manager","Cashier","CEO","Chief_Information_Officer","Customer_Service_Manager","Dairy_Person",
                        "Director_Recruitment","Exec_Assistant_Finance","Exec_Assistant_Human_Resources","Exec_Assistant_Legal_Counsel",
                        "Exec_Assistant_VP_Stores","Legal_Counsel","Meats_Cutter","Meats_Manager","Processed_Foods_Manager","Produce_Clerk",
                        "Produce_Manager","Shelf_Stocker","Store_Manager","VP_Finance","VP_Human_Resources","VP_Stores")
table1_4
new_table1_4 <- as.data.frame.matrix(table1_4)
new_table1_4['length_of_service'] <- c(10:26)

#plotting 
A1Q4_plot <- ggplot(new_table1_4, aes(color = Position)) +
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Baker, colour= "Baker"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Bakery_Manager, colour= "Bakery Manager"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Cashier, colour= "Cashier"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = CEO, colour= "CEO"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Chief_Information_Officer, colour= "Chief Information Officer"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Customer_Service_Manager, colour= "Bakery Manager"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Dairy_Person, colour= "Dairy Person"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Director_Recruitment, colour= "Director, Recruitment"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Exec_Assistant_Finance, colour= "Exec assistant, Finance"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Exec_Assistant_Human_Resources, colour= "Exec Assistant, Human Resources"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Exec_Assistant_Legal_Counsel, colour= "Exec Assistant, Legal Counsel"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Exec_Assistant_VP_Stores, colour= "Exec Assistant, VP Stores"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Legal_Counsel, colour= "Legal Counsel"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Meats_Cutter, colour= "Meats Cutter"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Meats_Manager, colour= "Meats Manager"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Processed_Foods_Manager, colour= "Processed Foods Manager"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Produce_Clerk, colour= "Produce Clerk"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Produce_Manager, colour= "Produce Manager"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Shelf_Stocker, colour= "Shelf Stocker"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = Store_Manager, colour= "Store Manager"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = VP_Finance, colour= "VP Finance"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = VP_Human_Resources, colour= "VP Human Resources"), stat='identity')+
  geom_point(data = new_table1_4, mapping= aes(x = length_of_service, y = VP_Stores, colour= "VP Stores"), stat='identity')+ theme_bw()+
  labs(title="Length of Service for more than 10 years", x = "Length of Service", y = "Number of employees") + coord_flip()
A1Q4_plot

#A2 - Find out their age and their relevant position for those serviced for more than 10 years
#Data Transformation
table2_4 <- table(clean_after10$age, clean_after10$job_title)
colnames(table2_4) <- c("Baker","Bakery_Manager","Cashier","CEO","Chief_Information_Officer","Customer_Service_Manager","Dairy_Person",
                        "Director_Recruitment","Exec_Assistant_Finance","Exec_Assistant_Human_Resources","Exec_Assistant_Legal_Counsel",
                        "Exec_Assistant_VP_Stores","Legal_Counsel","Meats_Cutter","Meats_Manager","Processed_Foods_Manager","Produce_Clerk",
                        "Produce_Manager","Shelf_Stocker","Store_Manager","VP_Finance","VP_Human_Resources","VP_Stores")
table2_4
new_table2_4 <- as.data.frame.matrix(table2_4)
new_table2_4['age'] <- c(36:64)
new_table2_4

#Plotting Line
A2Q4_plot <- ggplot(new_table2_4, aes(color = Position)) +
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Baker, colour= "Baker"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Bakery_Manager, colour= "Bakery Manager"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Cashier, colour= "Cashier"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = CEO, colour= "CEO"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Chief_Information_Officer, colour= "Chief Information Officer"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Customer_Service_Manager, colour= "Bakery Manager"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Dairy_Person, colour= "Dairy Person"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Director_Recruitment, colour= "Director, Recruitment"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Exec_Assistant_Finance, colour= "Exec assistant, Finance"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Exec_Assistant_Human_Resources, colour= "Exec Assistant, Human Resources"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Exec_Assistant_Legal_Counsel, colour= "Exec Assistant, Legal Counsel"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Exec_Assistant_VP_Stores, colour= "Exec Assistant, VP Stores"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Legal_Counsel, colour= "Legal Counsel"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Meats_Cutter, colour= "Meats Cutter"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Meats_Manager, colour= "Meats Manager"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Processed_Foods_Manager, colour= "Processed Foods Manager"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Produce_Clerk, colour= "Produce Clerk"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Produce_Manager, colour= "Produce Manager"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Shelf_Stocker, colour= "Shelf Stocker"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = Store_Manager, colour= "Store Manager"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = VP_Finance, colour= "VP Finance"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = VP_Human_Resources, colour= "VP Human Resources"), stat='identity')+
  geom_line(data = new_table2_4, mapping= aes(x = age, y = VP_Stores, colour= "VP Stores"), stat='identity')+ theme_bw()+
  labs(title="Age Compared to their position", x = "Age", y = "Number of employees")
A2Q4_plot

#A3 - Find the age distribution of employees that worked more than 10 years 
table4_3 <- table(clean_after10$age)
new_table4_3 <- data.frame(table4_3)
colnames(new_table4_3) <- c("Age", "Number_of_employees")
new_table4_3

A3Q4_plot <- ggplot(clean_after10)+
  geom_histogram(data = new_table4_3, mapping = aes(x = Age, y = Number_of_employees),stat = 'identity', fill = "light blue") + 
  geom_text(data = new_table4_3, mapping = aes(x = Age, y = Number_of_employees + 3, label = Number_of_employees))+
  theme_classic()+ labs(title = "Number of Employees in each Age group", x = "Age", y = "Number of employees")
A3Q4_plot

#Q5 - Is the company expanding?
#Data Cleaning
clean_active_2006 <- filter(dataset, recorddate_key == "12/31/2006 0:00")
clean_active_2006_2 <- filter(clean_active_2006, STATUS =="ACTIVE")

#A1 - Find the number of employees in each stores from year 2006 and 2015
#Data transformation
group_stores2006 <- table(clean_active_2006_2$store_name)
group_stores2015 <- table(clean_active$store_name)
new_group_stores2006 <- data.frame(group_stores2006)
new_group_stores2015 <- data.frame(group_stores2015)
colnames(new_group_stores2006) <- c("Store_names","Number_of_Employees")
colnames(new_group_stores2015) <- c("Store_names", "Number_of_Employees")

#plotting line graph
A1Q5_plot <- ggplot(dataset, aes(color = Year))+
  geom_point(data = new_group_stores2006, mapping = aes(x = Store_names, y = Number_of_Employees, colour = "2006"),stat = 'identity')+
  geom_line(data = new_group_stores2006, mapping = aes(x = Store_names, y = Number_of_Employees, colour = "2006", group = 1),stat = 'identity')+
  geom_point(data = new_group_stores2015, mapping = aes(x = Store_names, y = Number_of_Employees, colour = "2015"),stat = 'identity')+ 
  geom_line(data = new_group_stores2015, mapping = aes(x = Store_names, y = Number_of_Employees, colour = "2015", group = 1),stat = 'identity')+ 
  theme_classic() + labs(title = "Number of employess in each store between 2006 and 2015", x = "Store Names", y = "Number of Employees")
A1Q5_plot

#A2 - Find the number of total employees in between 2006 and 2015
group_employees2006 <- nrow(clean_active_2006_2)
group_employees2015 <- nrow(clean_active)

new_table2_5 <- data.frame(group_employees2006, group_employees2015)
new_table2_5

A2Q5_plot <- ggplot(dataset)+
  geom_bar(data = new_table2_5, mapping = aes(x = "2006", y = group_employees2006), stat = 'identity', fill ="dark green", col = "black")+
  geom_bar(data = new_table2_5, mapping = aes(x = "2015", y = group_employees2015), stat = 'identity', fill ="light green", col = "black")+
  theme_bw() + labs(title = "Number of total employees in between 2006 and 2015", x = "Year", y = "Number of employees")
A2Q5_plot

#A3 - Find the number of terminated employees in between 2006 and 2015
table3_5 <- table(clean_terminated$STATUS_YEAR)
new_table3_5 <- data.frame(table3_5)
colnames(new_table3_5) = c("Years", "Number_of_terminated_employees")
new_table3_5

A3Q5_plot <- ggplot(clean_terminated, aes(color = "Years"))+
  geom_bar(data = new_table3_5, mapping = aes(x = Years, y = Number_of_terminated_employees, colour = Years),stat = 'identity', fill = "white")+
  theme_bw() + labs(title = "Number of terminated employees in between years" , x = "Years", y = "Number of Terminated Employees")
A3Q5_plot

#Extra Features - Pie()
pie(new_table3_5$Number_of_terminated_employees, labels = new_table3_5$Number_of_terminated_employees, 
    col = rainbow(length(new_table3_5$Number_of_terminated_employees)))
legend('bottomright', c("2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014","2015"), 
       fill = rainbow(length(new_table3_5$Number_of_terminated_employees)))


