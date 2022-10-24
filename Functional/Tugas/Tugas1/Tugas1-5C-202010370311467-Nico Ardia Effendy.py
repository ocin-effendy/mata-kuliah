import getpass
from os import system
import sqlite3
from sqlite3 import Error

con = sqlite3.connect('product.db')
cur = con.cursor()


cur.execute(''' SELECT count(name) FROM sqlite_master WHERE type='table' AND name='PRODUCT' ''')
if cur.fetchone()[0] != 1:
    try:
        cur.execute("""CREATE TABLE PRODUCT(NAME VARCHAR(255), PRICE VARCHAR(255), STOCK VARCHAR(255));""")
    except Error as e:
        print(e)


seller = {"username": "admin", "password": "admin"}
buyer = []

# function for validation data input buyer
def validationData(username, password):
    for i in buyer:
        if username in i and password in i:
            return True


# function return message erorr
def messageError(message):
    print(message)
    input("enter")

# Login Page
def loginPage():
    system('clear')
    print("============== Login Page ==================")
    username = input("Username : ")
    password = getpass.getpass("password : ")
    if username == seller["username"] and password == seller["password"]:
        menuSeller()
    elif validationData(username, password):
        menuBuyer()
    else:
        messageError("User not found")

# Register Page
def registerPage():
    system('clear')
    print("============== Regiser Page ==================")
    username = input("Username : ")
    password = getpass.getpass("password : ")
    if validationData(username, password):
        messageError("User already exist!")
    else:
        buyer.append(list((username, password)))


# function for buy item
def buyItem():
    printAllProduct("buyer")
    name = input("Select name for buy : ")
    if validationItemProduct(name):
        try:
            cursor = con.execute("SELECT STOCK from PRODUCT where NAME = '" + name + "'")
            count = int(cursor.fetchone()[0]) 
            if count > 0:
                con.execute("UPDATE PRODUCT set STOCK = '" + str(count-1) + "' where NAME = '" + name + "'")
                con.commit()
                input("Buying " + name + " Succusefully")
            else:
                messageError("Product sold out!")

        except Error as e:
            print(e)

    else:
        messageError("Product not exist")



# Buyer menu after login
def menuBuyer():
    loop = True
    while loop:
        system('clear')
        print("============== Home ==================")
        print("1. List Items Produk")
        print("2. Buy Items")
        print("3. Log out")
        value = int(input("Select : "))
        if value == 1:
            printAllProduct("buyer")
            input("enter")
        elif value == 2:
            buyItem()
        else:
            loop = False

# print all product
def printAllProduct(message):
    cursor = con.execute("SELECT NAME, PRICE, STOCK from PRODUCT")
    for row in cursor:
        if message == "buyer":
            if int(row[2]) != 0:
                print("\nName : " + row[0])
                print("Price : " + row[1])
                print("Stock : " + row[2])
        else:
            print("\nName : " + row[0])
            print("Price : " + row[1])
            print("Stock : " + row[2])




# function for validation item product
def validationItemProduct(name):
    cursor = con.execute("SELECT NAME from PRODUCT where NAME = '" + name + "'")
    if cursor.fetchone()[0] == name: 
        return True
  


# function for add items to database
def addItemProduct():
    system('clear')
    print("============== All Product ==================")
    name = input("Name Product : ")
    price = input("Price Product : ")
    stock = input("Stock Product : ")
    script = "INSERT INTO PRODUCT (NAME, PRICE, STOCK ) VALUES (?, ?, ?);"
    try:
        con.execute(script,(name, price, stock))
        con.commit()
        input("Add " + name + " Succusefully")
    except Error as e:
        print(e)

# function for delete item
def deleteItemProduct():
    printAllProduct("seller")
    name = input("Select name to delete : ")
    if validationItemProduct(name):
        try:
            con.execute("DELETE from PRODUCT where NAME = '" + name + "'")
            con.commit()
            input("Delete " + name + " Succusefully")
        except Error as e:
            print(e)
    else:
        messageError("Product not exist")
    
# function for update item
def updateItemProduct():
    type = ''
    value = ''
    printAllProduct("seller")
    name = input("Select name to update : ")
    if validationItemProduct(name):
        print("1. Update Name")
        print("2. Update Price")
        print("3. Update Stock")
        i = int(input("Select : "))
        if i == 1:
            type = "NAME"
            value = input("New Name : ")
        elif i == 2:
            type = "PRICE"
            value = input("New Price : ")
        elif i == 3:
            type = "STOCK"
            value = input("New Stock : ")
        else:
            messageError("Wrong Input")

        if i <=3 and i > 0:
            try:
                con.execute("UPDATE PRODUCT set " + type + " = " + "'" + value + "'" + " where NAME = '"+ name + "'")
                con.commit()
                input("Update " + type + " Succusefully")
            except Error as e:
                print(e)
    else:
        messageError("Product no exist")



# Menu admin
def menuSeller():
    loop = True
    while loop:
        system('clear')
        print("============== Welcome Seller ==================")
        print("1. Add Product")
        print("2. Update Product")
        print("3. List Product")
        print("4. Delete Product")
        print("5. Log out")
        value = int(input("Select: "))
        if value == 1:
            addItemProduct()
        elif value == 2:
            updateItemProduct()
        elif value == 3:
            printAllProduct("seller")
            input("enter")
        elif value == 4:
            deleteItemProduct()
        else:
            loop = False


loop = True
while loop:
    system('clear')
    print("============== Online Shop ==================")
    print("1. Login")
    print("2. Register")
    print("3. Exit")
    value = int(input("Select : "))
    if value == 1:
        loginPage()
    elif value == 2:
        registerPage()
    elif value == 3:
        loop = False
    else:
        messageError("Wrong input")



con.commit()
con.close()
