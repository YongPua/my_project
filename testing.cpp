#include <iostream>
#include <string>
#include <cstdlib>
#include <fstream>
#include <sstream>
#include <vector>
#include <string.h>
#include <ctime>
#include <iomanip>


using namespace std;
string position;

struct Vehicle
{
    int vehicleID;
    string vehicleName;
    string VehicleBrand;
    struct Date;
    double price;
    Vehicle* next;
};

struct Date
{
    int dd;
    int mm;
    int yyyy;
    Date* next;
};

struct Date1 {
    int day;
    int month;
    int year;
};

struct salesInvoice {
    string invoiceID;
    string bookingID;
    string depositPaid;
    string subTotal;
    string discount;
    string totalAmount;
    string balanceDue;
    string receiptID;
    Date1 invoiceDate;
    salesInvoice* next;
};

struct billReceipt {
    string receiptID;  
    Date1 billingDate;
    string invoiceID;
    string depositPaid;
    string subTotal;
    string discount;
    string totalAmount;
    string balanceDue;
    billReceipt* next;
};

struct Client {
    string ID;
    string name;
    string email;
    int age;
    string number;
    Client* next;
};

struct BookingInfo {
    int bookingID;
    string model;
    string regDate;
    int price;
    BookingInfo* next;
};

//invoice class
class InvoiceLinkedList {
public:
    InvoiceLinkedList() {
        head = nullptr;
        tail = nullptr;
    }

    ~InvoiceLinkedList() {
        salesInvoice* temp = head;
        while (temp != nullptr) {
            salesInvoice* next = temp->next;
            delete temp;
            temp = next;
        }
        head = nullptr;
        tail = nullptr;
    }


    // Function to search for a sales invoice node in the linked list by invoice ID
    salesInvoice* searchInvoice(string invoiceID) {
        salesInvoice* current = head;
        while (current != nullptr) {
            if (current->invoiceID == invoiceID) {
                return current;
            }
            current = current->next;
        }
        return nullptr; // invoice not found
    }

    void run() {
        int choice;

        do {
            cout << "\nChoose your option:\n1. Add data to invoice list\n2. Display Invoice Linked List\n3. Display Specific Invoice\n0. Quit\n--> ";
            cin >> choice;

            switch (choice) {
            case 1:
                add();
                break;
            case 2:
                displayinvoicelist();
                break;
            case 3:
                displaySpecificInvoice();
                break;
            case 0:
                break;
            default:
                cout << "\nInvalid choice." << endl;
            }
        } while (choice != 0);

    }

    void add() {
        string invoiceID;
        string depositPaid;
        string subTotal;
        string discount;
        string totalAmount;
        string balanceDue;
        string receiptID;
        string bookingID;
        Date1 invoiceDate;

        cout << "\nEnter invoiceID: ";
        cin >> invoiceID;
        cout << "Enter bookingID: ";
        cin >> bookingID;
        cout << "Enter Deposit Paid: ";
        cin >> depositPaid;
        cout << "Enter SubTotal: ";
        cin >> subTotal;
        cout << "Enter Discount: ";
        cin >> discount;
        cout << "Enter invoice date (DD MM YYYY): ";
        cin >> invoiceDate.day >> invoiceDate.month >> invoiceDate.year;

        // Compute total amount
        float subtotalFloat = std::stof(subTotal);
        float discountFloat = std::stof(discount);
        float depositPaidFloat = std::stof(depositPaid);
        float totalAmountFloat = subtotalFloat - discountFloat;
        totalAmount = std::to_string(totalAmountFloat);

        // Compute balance due
        float balanceDueFloat = totalAmountFloat - std::stof(depositPaid);
        balanceDue = std::to_string(balanceDueFloat);

        salesInvoice* newNode = new salesInvoice();
        newNode->invoiceID = invoiceID;
        newNode->bookingID = bookingID;
        newNode->depositPaid = depositPaid;
        newNode->subTotal = subTotal;
        newNode->discount = discount;
        newNode->totalAmount = totalAmount;
        newNode->balanceDue = balanceDue;
        newNode->invoiceDate = invoiceDate;
        newNode->next = nullptr;

        if (head == nullptr) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail->next = newNode;
            tail = newNode;
        }
    }


    void displayinvoicelist() {
        if (head == nullptr) {
            cout << "\nList is empty." << endl;
        }
        else {
            salesInvoice* temp = head;
            while (temp != nullptr) {
                cout << "Invoice ID: " << temp->invoiceID << ", Booking ID: " << temp->bookingID << ", Deposit Paid:" << temp->depositPaid << ", Sub Total:" << temp->subTotal << ", Discount: " << temp->discount << ", Total Amount: " << temp->totalAmount << ", Balance Due: " << temp->balanceDue << ", Invoice Date: " << temp->invoiceDate.day << "/" << temp->invoiceDate.month << "/" << temp->invoiceDate.year << endl;
                temp = temp->next;
            }
        }
    }

    void displaySpecificInvoice() {
        string invoiceID;
        cout << "\nEnter specific invoice ID: ";
        cin >> invoiceID;

        salesInvoice* temp = head;
        while (temp != nullptr) {
            if (temp->invoiceID == invoiceID) {
                cout << "Invoice ID: " << temp->invoiceID << ", Booking ID: " << temp->bookingID << ", Deposit Paid:" << temp->depositPaid << ", Sub Total:" << temp->subTotal << ", Discount: " << temp->discount << ", Total Amount: " << temp->totalAmount << ", Balance Due: " << temp->balanceDue << ", Invoice Date: " << temp->invoiceDate.day << "/" << temp->invoiceDate.month << "/" << temp->invoiceDate.year << endl;
                return;
            }
            temp = temp->next;
        }
        cout << "Invoice not found." << endl;
    }

    // Function to merge two sorted linked lists
    salesInvoice* merge(salesInvoice* head1, salesInvoice* head2) {
        if (head1 == NULL) return head2;
        if (head2 == NULL) return head1;

        salesInvoice* mergedHead;
        if (head1->invoiceDate.year < head2->invoiceDate.year || (head1->invoiceDate.year == head2->invoiceDate.year && head1->invoiceDate.month < head2->invoiceDate.month) ||
            (head1->invoiceDate.year == head2->invoiceDate.year && head1->invoiceDate.month == head2->invoiceDate.month && head1->invoiceDate.day < head2->invoiceDate.day)) {
            mergedHead = head1;
            mergedHead->next = merge(head1->next, head2);
        }
        else {
            mergedHead = head2;
            mergedHead->next = merge(head1, head2->next);
        }
        return mergedHead;
    }

    // Function to split a linked list into two halves
    void split(salesInvoice* head, salesInvoice** firstHalf, salesInvoice** secondHalf) {
        salesInvoice* slow = head;
        salesInvoice* fast = head->next;

        while (fast != NULL) {
            fast = fast->next;
            if (fast != NULL) {
                slow = slow->next;
                fast = fast->next;
            }
        }

        *firstHalf = head;
        *secondHalf = slow->next;
        slow->next = NULL;
    }

    // Merge sort function for the linked list of sale invoices
    void mergeSort(salesInvoice** headRef) {
        salesInvoice* head = *headRef;
        salesInvoice* firstHalf;
        salesInvoice* secondHalf;

        // Base case: empty or single-node list
        if (head == NULL || head->next == NULL) return;

        // Split the list into two halves
        split(head, &firstHalf, &secondHalf);

        // Recursively sort the two halves
        mergeSort(&firstHalf);
        mergeSort(&secondHalf);

        // Merge the two sorted halves
        *headRef = merge(firstHalf, secondHalf);
    }

    //GENERATE SALE REPORT
    void generateSaleReport(salesInvoice* temp, int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear) {
        // Validate input dates
        if (startDay < 1 || startDay > 31 || endDay < 1 || endDay > 31 || startMonth < 1 || startMonth > 12
            || endMonth < 1 || endMonth > 12 || startYear < 1900 || endYear < 1900) {
            cout << "Invalid date input!" << endl;
            return;
        }

        // Print the header for the report
        cout << "Sale Report (" << startDay << "/" << startMonth << "/" << startYear << " - " << endDay << "/" << endMonth << "/" << endYear << "):" << endl;
        cout << left << setw(15) << "Invoice ID" << setw(15) << "Booking ID" << setw(15) << "Deposit Paid"
            << setw(15) << "Sub Total" << setw(15) << "Discount" << setw(15) << "Total Amount"
            << setw(15) << "Balance Due" << setw(15) << "Invoice Date" << endl;
        cout << setfill('-') << setw(135) << "-" << setfill(' ') << endl;

        // Traverse the linked list and print each invoice's information if it falls within the specified date range
        while (temp != NULL) {
            if (temp->invoiceDate.year >= startYear && temp ->invoiceDate.year <= endYear) {
                if (temp->invoiceDate.month >= startMonth && temp->invoiceDate.month <= endMonth) {
                    if (temp->invoiceDate.day >= startDay && temp->invoiceDate.day <= endDay) {
                        cout << left << setw(15) << temp->invoiceID << setw(15) << temp->bookingID << setw(15) << temp->depositPaid
                            << setw(15) << temp->subTotal << setw(15) << temp->discount << setw(15) << temp->totalAmount
                            << setw(15) << temp->balanceDue
                            << temp->invoiceDate.day << "/" << setw(2) << temp->invoiceDate.month << "/" << temp->invoiceDate.year << endl;
                    }
                }
            }
            temp = temp->next;
        }
    }

    //CHOOSE DATE RANGE FOR SALES INVOICE
    void reportDateRange() {
        // Create a linked list of sale invoices
        salesInvoice* temp = head;
        //head = NULL;
        int startDay, startMonth, startYear;
        int endDay, endMonth, endYear;

        cout << "Please enter the start date (dd mm yyyy): ";
        cin >> startDay >> startMonth >> startYear;
        cout << "Please enter the end date (dd mm yyyy): ";
        cin >> endDay >> endMonth >> endYear;

        // Print the unsorted list of sale invoices
        cout << "\n \nUnsorted sale invoices:" << endl;
        generateSaleReport(temp, startDay, startMonth, startYear, endDay, endMonth, endYear);

        // Sort the list of sale invoices by date
        mergeSort(&temp);
        // Print the sorted list of sale invoices
        cout << "\n \nSorted sale invoices by date:" << endl;
        generateSaleReport(temp, startDay, startMonth, startYear, endDay, endMonth, endYear);

    }

private:
    salesInvoice* head;
    salesInvoice* tail;
};



//bill receipt class
class BillReceipt {
public:
    BillReceipt(InvoiceLinkedList& invoiceList) : invoiceList(invoiceList), head(nullptr), tail(nullptr) {}


    ~BillReceipt() {
        billReceipt* temp = head;
        while (temp != nullptr) {
            billReceipt* next = temp->next;
            delete temp;
            temp = next;
        }
        head = nullptr;
        tail = nullptr;
    }



    void run() {
        int choice;

        do {
            cout << "\nChoose your option:\n1. Add data to receipt list\n2. Display BillReceipt Linked List\n3. Display Specific BillReceipt\n0. Quit\n--> ";
            cin >> choice;

            switch (choice) {
            case 1:
                addbillreceipt();
                break;
            case 2:
                displaybilllist();
                break;
            case 3:
                displaySpecificBill();
                break;
            case 0:
                break;
            default:
                cout << "\nInvalid choice." << endl;
            }
        } while (choice != 0);

    }

    void addbillreceipt() {
        string receiptID;;
        Date1 billingDate;
        string invoiceID;
        string depositPaid;
        string subTotal;
        string discount;
        string totalAmount;
        string balanceDue;

        cout << "\nEnter receiptID: ";
        cin >> receiptID;
        cout << "Enter billingDate (DD MM YYYY): ";
        cin >> billingDate.day >> billingDate.month >> billingDate.year;
        cout << "\nEnter invoiceID: ";
        cin >> invoiceID;


        salesInvoice* invoice = invoiceList.searchInvoice(invoiceID);
        if (invoice == nullptr) {
            cout << "Invoice not found.\n";
            return;
        }

        billReceipt* newNode = new billReceipt();
        newNode->receiptID = receiptID;
        newNode->billingDate = billingDate;
        newNode->invoiceID = invoiceID;
        newNode->depositPaid = invoice->depositPaid;
        newNode->subTotal = invoice->subTotal;
        newNode->discount = invoice->discount;
        newNode->totalAmount = invoice->totalAmount;
        newNode->balanceDue = invoice->balanceDue;
        newNode->next = nullptr;


        if (head == nullptr) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail->next = newNode;
            tail = newNode;
        }
    }

    void displaybilllist() {
        if (head == nullptr) {
            cout << "\nList is empty." << endl;
        }
        else {

            billReceipt* temp = head;
            while (temp != nullptr) {
                cout << " Receipt ID: " << temp->receiptID <<  ", billReceipt Date : " << temp->billingDate.day << " / " << temp->billingDate.month << " / " << temp->billingDate.year << ", deposit Paid : "  << temp->depositPaid << ", subTotal : " << temp->subTotal << ", total amount : " << temp->totalAmount << ", Discount : " << temp->discount << ", balance due : " << temp->balanceDue << endl;
                temp = temp->next;
            }
        }
    }

    void displaySpecificBill() {
        string receiptID;
        cout << "\nEnter specific receipt ID: ";
        cin >> receiptID;

        billReceipt* temp = head;
        while (temp != nullptr) {
            if (temp->receiptID == receiptID) {
                cout << " Receipt ID: " << temp->receiptID << ", billReceipt Date : " << temp->billingDate.day << " / " << temp->billingDate.month << " / " << temp->billingDate.year << ", deposit Paid : " << temp->depositPaid << ", subTotal : " << temp->subTotal << ", total amount : " << temp->totalAmount << ", Discount : " << temp->discount << ", balance due : " << temp->balanceDue << endl;
                return;
            }
            temp = temp->next;
        }
        cout << "Invoice not found." << endl;
    }

    void generateBillReport(billReceipt* temp, int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear) {
    // Validate input dates
    if (startDay < 1 || startDay > 31 || endDay < 1 || endDay > 31 || startMonth < 1 || startMonth > 12
        || endMonth < 1 || endMonth > 12 || startYear < 1900 || endYear < 1900) {
        cout << "Invalid date input!" << endl;
        return;
    }

    // Print the header for the report
    cout << "Bill Report (" << startDay << "/" << startMonth << "/" << startYear << " - " << endDay << "/" << endMonth << "/" << endYear << "):" << endl;
    cout << left << setw(15) << "Receipt ID" << setw(15) << "Deposit Paid"
        << setw(15) << "Sub Total" << setw(15) << "Discount" << setw(15) << "Total Amount"
        << setw(15) << "Invoice Date" << endl;
    cout << setfill('-') << setw(135) << "-" << setfill(' ') << endl;

    // Traverse the linked list and print each invoice's information if it falls within the specified date range
    if (temp == nullptr) {
        cout << "No bill found." << endl;
    }
    else {
        while (temp != NULL) {
            if (temp->billingDate.year >= startYear && temp->billingDate.year <= endYear) {
                if (temp->billingDate.month >= startMonth && temp->billingDate.month <= endMonth) {
                    if (temp->billingDate.day >= startDay && temp->billingDate.day <= endDay) {
                        cout << left << setw(15) << temp->receiptID << setw(15) << temp->depositPaid
                            << setw(15) << temp->subTotal << setw(15) << temp->discount << setw(15) << temp->totalAmount
                            << temp->billingDate.day << "/" << setw(2) << temp-> billingDate.month << "/" << temp-> billingDate.year << endl;
                    }
                }
            }
            temp = temp->next;
        }
    }
}


    //CHOOSE DATE RANGE FOR BILLING
    void billDateRange() {
        billReceipt* temp = head;
        //head = NULL;
        int startDay, startMonth, startYear;
        int endDay, endMonth, endYear;
        int billchoice;
        cout << "Please enter the start date (dd mm yyyy): ";
        cin >> startDay >> startMonth >> startYear;
        cout << "Please enter the end date (dd mm yyyy): ";
        cin >> endDay >> endMonth >> endYear;

        // Sort the list of billing by date
        generateBillReport(temp, startDay, startMonth, startYear, endDay, endMonth, endYear);

    }
private:
    InvoiceLinkedList& invoiceList;
    billReceipt* head;
    billReceipt* tail;

};



class client{
public:
    // Manage Client Function
    void manageClient() {
        int choice = 0;
        string clientsID = "0";
        Client* head = nullptr;
        client call;
        //head = NULL;
        do
        {
            cout << endl << "1. Add Clients" << endl;
            cout << "2. Display Clients" << endl;
            cout << "3. Delete Clients" << endl;
            cout << "4. Exit" << endl;
            cout << "Enter your option:";
            cin >> choice;

            if (choice == 1) {
                addClient();
            }
            else if (choice == 2) {
                displayClients();
            }
            else if (choice == 3) {
                cout << endl << "Enter Client's ID" << endl;
                cin >> clientsID;
                deleteClient(clientsID);
                cout << endl;
            }
            else if (choice == 4) {
                return;
            }
            else
                cout << "Invalid options, please try again";
        } while (choice != 4);
}

    // GENERATE CLIENT REPORT
    void generateClientReport() {
        // Print the header for the report
        Client* temp = head;
        //head = NULL;

        cout << "\n \nClient Report:" << endl;
        cout << left << setw(15) << "ClientID" << setw(15) << "Name" << setw(15) << "Email"
            << setw(15) << "Age" << setw(15) << "Phone Number" << endl;
        cout << setfill('-') << setw(100) << "-" << setfill(' ') << endl;
    while(temp != NULL){
        cout << left << setw(15) << temp->ID << setw(15) << temp->name << setw(15) << temp->email
            << setw(15) << temp->age << setw(15) << temp->number << endl;
        temp = temp -> next;
    } 
    
}

//ADD CLIENT
    void addClient() {
        Client* newClient = new Client;

        cout << "Enter client ID: ";
        cin >> newClient->ID;
        while (cin.fail()) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Invalid input. Please enter a valid client ID: ";
            cin >> newClient->ID;
        }

        cout << "Enter client name: ";
        cin >> newClient->name;
        while (cin.fail()) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Invalid input. Please enter a valid client name: ";
            cin >> newClient->name;
        }

        cout << "Enter client email: ";
        cin >> newClient->email;
        while (cin.fail()) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Invalid input. Please enter a valid client email: ";
            cin >> newClient->email;
        }

        cout << "Enter client age: ";
        cin >> newClient->age;
        while (cin.fail()) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Invalid input. Please enter a valid client age: ";
            cin >> newClient->age;
        }

        cout << "Enter client phone number: ";
        cin >> newClient->number;
        while (cin.fail()) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Invalid input. Please enter a valid client phone number: ";
            cin >> newClient->number;
        }


        newClient->next = head;
        head = newClient;

        cout << endl << "Client added sucessfully" << endl << endl;

    }

//DISPLAY CLIENT
    void displayClients() {
        Client* current = head;
        if (current == NULL){
            cout << "No Client Registered";
        } else{
            while (current != nullptr) {
                cout << "ID: " << current->ID << " | ";
                cout << "Name: " << current->name << " | ";
                cout << "Email: " << current->email << " | ";
                cout << "Age: " << current->age << " | ";
                cout << "Phone Number:" << current->number << endl;
                current = current->next;
            }
        }
    }

//DELETE CLIENT
    void deleteClient(string ClientsID) {
        if (head == NULL) {
            cout << "Client not found";
            return;
        }
        // check if head needs to be deleted
        if (head->ID == ClientsID) {
            Client* temp = head;
            head = head->next;
            delete temp;
            cout << "Deleted sucessfully.";
            return;
        }

        // find the node to delete and its previous node
        Client* prev = head;
        Client* current = head->next;
        while (current != nullptr && current->ID != ClientsID) {
            prev = current;
            current = current->next;
        }
        // if the node was found, delete it
        if (current != nullptr) {
            prev->next = current->next;
            delete current;
            cout << "Deleted sucessfully.";
        }
        else {
            cout << "Client with ID " << ClientsID << " not found" << endl;
        }
    }

private:
    Client* head;
};




//MAIN MENU
void view_salesperson_menu()
{
    cout << "\n1. Manage Client" << endl;
    cout << "2. Book Vehicle" << endl;
    cout << "3. Search Vehicle" << endl;
    cout << "4. Create Sale Invoice" << endl;
    cout << "5. Create Bill" << endl;
    cout << "6. Log Out" << endl;
}

void view_manager_menu()
{
    cout << "\n1. Search Vehicle" << endl;
    cout << "2. Create Sale Invoice" << endl;
    cout << "3. Create bill" << endl;
    cout << "4. Produce Sale Invoice Report" << endl;
    cout << "5. Produce Bill Report" << endl;
    cout << "6. Produce Client Report" << endl;
    cout << "7. Log Out" << endl;
}


//FUNCTION DECLARATION
void manager_access();
void salesperson_access();


//READ EXCEL FILE
vector<vector<string> > readExcelFile()
{
    string fname = "/Users/yongpua/Desktop/C++/carlist.csv";
    //content container for csv
    vector<vector<string> > content;
    vector<string> row;
    string line, word;
    fstream file(fname, ios::in);
    if (file.is_open())
    {
        while (getline(file, line))
        {
            row.clear();
            stringstream str(line);
            //skip the line start with quotation mark
            if (line[0] == 34)
            {
                continue;
            }
            while (getline(str, word, ','))
                row.push_back(word);
            content.push_back(row);
        }
    }
    else
    {
        cout << "Could not open the file\n";
    }
    return content;
}


//SEARCH VEHICLE
bool checkTransmissionType(string vehicleTransmissionType, string type)
{
    if (type == "M" && vehicleTransmissionType == "Manual")
    {
        return true;
    }
    if (type == "A" && vehicleTransmissionType == "Automatic")
    {
        return true;
    }
    if (type == "S" && vehicleTransmissionType == "Semi-Automatic")
    {
        return true;
    }
    return false;
}

bool checkFuelType(string vehicleFuelType, string inputFuelType)
{
    if (inputFuelType == "D" && vehicleFuelType == "Diesel")
    {
        return true;
    }
    if (inputFuelType == "P" && vehicleFuelType == "Petrol")
    {
        return true;
    }
    if (inputFuelType == "U" && vehicleFuelType == "Unleaded")
    {
        return true;
    }
    return false;
}

void searchVehicle(string transmissionType, string fuelType)
{
    vector<vector<string> > content;
    content = readExcelFile();
    int free_position = 1;
    //Sort register date using insertion sort
    for (int j = 2; j < content.size(); j++)
    {
        vector<string> currentRow = content[j];
        int date = stoi(content[j][3]);
        int i = j - 1;

        while (i >= 1 && stoi(content[i][3]) < date)
        {
            content[i + 1] = content[i];
            i--;
        }
        content[i + 1] = currentRow;
    }


    //Show the results based on the vehicle transmission type and registration date using linear search   
    vector<string> selectedVehicle;
    for (int i = 0; i < content.size(); i++)
    {
        bool inputTransmissionType = false;
        bool inputFuelType = false;
        for (int j = 0; j < content[i].size(); j++)
        {
            inputTransmissionType = checkTransmissionType(content[i][6], transmissionType);
            inputFuelType = checkFuelType(content[i][5], fuelType);

            if (inputTransmissionType == true && inputFuelType == true)
            {
                selectedVehicle.push_back(to_string(i) + "\t" + content[i][j]);
            }
        }

        if (inputTransmissionType == true && inputFuelType == true)
        {
            cout << i << "\t<" << content[i][0] << ">" << "\t" << content[i][3] << endl;
        }
    }


}

void searchVehicleFunction()
{
    string transmissionType, fuelType, answer;
    int flag = 0;
    cout << "Choose your transmission type: M/A/S (Manual/Automatic/Semi-Automatic)" << endl;
    cin >> transmissionType;
    cout << "Choose your fuel type: D/P/U (Diesel/Petrol/Unleaded)" << endl;
    cin >> fuelType;
    while (!((transmissionType == "M" || transmissionType == "A" || transmissionType == "S") && (fuelType == "D" || fuelType == "P" || fuelType == "U")))
    {
        cout << "Invalid Option!" << endl;
        cout << "Choose your transmission type: M/A/S (Manual/Automatic/Semi-Automatic)" << endl;
        cin >> transmissionType;
        cout << "Choose your fuel type: D/P/U (Diesel/Petrol/Unleaded)" << endl;
        cin >> fuelType;
    }
    searchVehicle(transmissionType, fuelType);

    while (flag == 0)
    {
        cout << "0 - Main Menu, 1 - Continue." << endl;
        cin >> answer;
        if (answer == "0" && position == "manager")
        {
            manager_access();
            flag = 1;
        }
        else if (answer == "0" && position == "salesperson")
        {
            salesperson_access();
            flag = 1;
        }
        else if (answer == "1")
        {
            cout << "Choose your transmission type: M/A/S (Manual/Automatic/Semi-Automatic)" << endl;
            cin >> transmissionType;
            cout << "Choose your fuel type: D/P/U (Diesel/Petrol/Unleaded)" << endl;
            cin >> fuelType;
            searchVehicle(transmissionType, fuelType);
            flag = 0;
        }
        else
        {
            cout << "Wrong Option!" << endl;
            flag = 0;
        }
    }
}

class booking{
public:

    void bookVehicle(vector<vector<string> > selectedVehicle) {
        // Create a new BookingInfo struct to store the vehicle details
        string VehicleID;

        cout << "\nPlease enter Vehicle ID for booking:";
        cin >> VehicleID;
        for (int i = 0; i < selectedVehicle.size(); i++)
        {
            vector<string> vehicle = selectedVehicle[i];
            if (VehicleID == vehicle[0]) {
                BookingInfo* newBooking = new BookingInfo();
                newBooking->bookingID = stoi(VehicleID);
                newBooking->model = vehicle[1];
                newBooking->price = stoi(vehicle[2]);
                newBooking->regDate = vehicle[3];

                newBooking->next = NULL;

                if (head == nullptr) {
                    head = newBooking;
                    tail = newBooking;
                }
                else {
                    tail->next = newBooking;
                    tail = newBooking;
                }

                cout << "\nBooking successful" << endl;
                return;
            }
        }
        cout << "\nInvalid Vehicle ID" << endl;
    }


    //Search Vehicle for Booking
    void searchVehicleforBooking(string transmissionType, string fuelType)
    {
        // Read vehicle data from file
        vector<vector<string> > content = readExcelFile();

        // Sort by registration date using insertion sort
        for (int j = 2; j < content.size(); j++)
        {
            vector<string> currentRow = content[j];
            int date = stoi(content[j][3]);
            int i = j - 1;

            while (i >= 1 && stoi(content[i][3]) < date)
            {
                content[i + 1] = content[i];
                i--;
            }
            content[i + 1] = currentRow;
        }

        // Show the results based on the vehicle transmission type and registration date
        vector<vector<string> > selectedVehicle;
        for (int i = 0; i < content.size(); i++)
        {
            bool inputTransmissionType = checkTransmissionType(content[i][6], transmissionType);
            bool inputFuelType = checkFuelType(content[i][5], fuelType);

            if (inputTransmissionType && inputFuelType)
            {
                vector<string> vehicle;
                vehicle.push_back(to_string(selectedVehicle.size() + 1));
                vehicle.push_back("<" + content[i][0] + ">");
                vehicle.push_back(content[i][2]);
                vehicle.push_back(content[i][3]);
                selectedVehicle.push_back(vehicle);

                cout << selectedVehicle.size() << "\t<" << content[i][0] << ">" << "\t" << content[i][3] << endl;
            }
        }

        // Book a selected vehicle if requested
        bookVehicle(selectedVehicle);
    }

    //Display Booking Status
    void bookingStatus() {
        BookingInfo* current = head;
        cout << left << setw(15) << "Booking ID" << setw(50) << "Model" << setw(15) << "Price" << setw(15) << "Registred Date" << setw(15) << endl;
        cout << setfill('-') << setw(135) << "-" << setfill(' ') << endl;

        // Traverse the linked list and print each booking's information
        if (current == nullptr) {
            cout << "\nList is empty." << endl;
        }
        else {
            while (current != nullptr) {
                cout << left << setw(15) << current->bookingID << setw(50) << current->model << setw(15) << current->price << setw(15) << current->regDate << setw(15) << endl;
                current = current->next;
            }
        }
    }

    //Booking Vehicle by Searching
    void bookVehicleFunction()
    {
        string transmissionType, fuelType, answer;
        int flag = 0;
        cout << "\nChoose your transmission type: M/A/S (Manual/Automatic/Semi-Automatic) :";
        cin >> transmissionType;
        cout << "\nChoose your fuel type: D/P/U (Diesel/Petrol/Unleaded) :";
        cin >> fuelType;
        while (!((transmissionType == "M" || transmissionType == "A" || transmissionType == "S") && (fuelType == "D" || fuelType == "P" || fuelType == "U")))
        {
            cout << "Invalid Option!" << endl;
            cout << "\nChoose your transmission type: M/A/S (Manual/Automatic/Semi-Automatic):";
            cin >> transmissionType;
            cout << "\nChoose your fuel type: D/P/U (Diesel/Petrol/Unleaded):";
            cin >> fuelType;
        }
        searchVehicleforBooking(transmissionType, fuelType);
    }

    //Manage Booking Function
    void manageBooking() {
        int flag = 0;
        string answer;
        while (flag == 0)
        {
            cout << "\n0 - Main Menu, 1 - Continue, 2 - Display Booking Status:";
            cin >> answer;
            if (answer == "0")
            {
                salesperson_access();
                flag = 1;
            }
            else if (answer == "1")
            {
                bookVehicleFunction();
            }
            else if (answer == "2")
            {
                bookingStatus();
            }
        }
    }

private:
BookingInfo* head;
BookingInfo* tail;

};
// Booking Vehicle

InvoiceLinkedList ill;
BillReceipt br(ill);
client call;
booking call2;

void login();

//ACCESS THE MAIN MENU
void manager_access()
{
    int manager_choice = 0;
    do
    {
        view_manager_menu();
        cout << "Enter your choice: ";
        cin >> manager_choice;

        switch (manager_choice)
        {
        case 1:
            cout << "Welcome to Search Vehicle Page" << endl;
            searchVehicleFunction();
            break;

        case 2:
            cout << "Welcome to Create Sale Invoice Page" << endl;
            ill.run();
            break;

        case 3:
            cout << "Welcome to Create Bill Page" << endl;
            br.run();
            break;

        case 4:
            cout << "Welcome to Produce Sale Invoice Report Page" << endl;
            ill.reportDateRange();
            break;

        case 5:
            cout << "Welcome to Produce Bill Report Page" << endl;
            br.billDateRange();
            break;

        case 6:
            cout << "Welcome to Produce Client Report Page" << endl;
            call.generateClientReport();
            break;

        case 7:
            cout << "Thanks for using the program." << endl;
            login();
            break;

        default:
            cout << "Invalid choice. Please try again!" << endl;
        }
    } while (manager_choice != 7);
}

void salesperson_access()
{
    int salesperson_choice = 0;


    do
    {
        view_salesperson_menu();
        cout << "Enter your choice: ";
        cin >> salesperson_choice;

        switch (salesperson_choice)
        {
        case 1:
            cout << "Welcome to Manage Client Page" << endl;
            call.manageClient();
            break;

        case 2:
            cout << "Welcome to Book Vehicle Page" << endl;
            call2.manageBooking();
            break;

        case 3:
            cout << "Welcome to Search Vehicle Page" << endl;
            searchVehicleFunction();
            break;

        case 4:
            cout << "Welcome to Create Sale Invoice Page" << endl;
            ill.run();
            break;

        case 5:
            cout << "Welcome to Create Bill Page" << endl;
            br.run();
            break;

        case 6:
            cout << "Thanks for using the program." << endl;
            login();
            break;

        default:
            cout << "Invalid choice. Please try again!" << endl;
        }
    } while (salesperson_choice != 6);

}



//LOGIN
void login()
{
    string username, password;
    int login_attempts = 3;

    while (login_attempts > 0)
    {
        cout << "Enter the username: ";
        cin >> username;
        cout << "Enter the password: ";
        cin >> password;

        if (username == "salesperson123" && password == "salesperson123")
        {
            position = "salesperson";
            cout << "Welcome Salesperson!" << endl;
            salesperson_access();
        }
        else if (username == "manager123" && password == "manager123")
        {
            position = "manager";
            cout << "Welcome Manager!" << endl;
            manager_access();
        }
        else
        {
            login_attempts--;
            if (login_attempts > 0)
            {
                cout << "Incorrect username or password. Please try again! " << login_attempts << " attempts left" << endl;
            }
            else
            {
                cout << "Maximum login attempts reached. Please try again later." << endl;
                exit(0);
            }

        }
    }
}


int main()
{
    login();
    return 0;
}
