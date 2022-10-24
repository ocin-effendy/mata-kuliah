import getpass
from os import system

seller = {"username": "admin", "password": "admin"}
buyer = []

product = [
    {
        "name": "buku",
        "price": "100",
        "stock": 0
    },
    {
        "name": "gelas",
        "price": "50",
        "stock": 5
    }
]

# function for validation data input buyer
def validationData(username, password):
    for i in buyer:
        if username in i and password in i:
            return True


# function return message erorr
def message(message):
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
        message("User not found")

"""
username dan password merupakan local variabel
variabel tersebut tidak bisa di akses di luar fungsi tersebut
sehingga hanya bisa di akses dalam fungsi tersebut.
"""
# Register Page
def registerPage():
    system('clear')
    print("============== Regiser Page ==================")
    username = input("Username : ") # local variabel
    password = getpass.getpass("password : ") # local variabel
    if validationData(username, password):
        message("User already exist!")
    else:
        buyer.append(list((username, password)))


"""" 
global nameInput 
nameInput merupakan variabel global yang dapat diakses di dalam method lain (validationItemProduct)
maka tidak perlu membuat variabel baru atau membuat parameter untuk mengakses variabel tersebut
sehingga dengan mudah membandingkan nilai di dalam fungsi dan variabel global tersebut
"""
# function for buy item
def buyItem():
    printAllProduct("buyer")
    global nameInput # Global Variabel
    nameInput = input("Select name for buy : ")
    productSelected = list(filter(validationItemProduct, product))
    if productSelected:
        productSelected[0]["stock"] -= 1
        message("Buying Successfully")
    else:
        message("Product not exist")


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


def fill(i):
    if i["stock"] == 0:
        return False
    else:
        return True

# print all product
def printAllProduct(message):
    if message == "seller":
        for i in product:
            print("Nama Barang : " + i["name"])
            print("Harga : " + i["price"])
            print("Stok : " + str(i["stock"]))
    else:
        listData = filter(fill, product) 
        for i in listData:
            print("Nama Barang : " + i["name"])
            print("Harga : " + i["price"])


# function for validation item product
def validationItemProduct(i):
    if i["name"] == nameInput: # Akses dari global variabel
        return True
    else:
        return False
  

"""" 
global nameInput 
nameInput merupakan variabel global yang dapat diakses di dalam method lain (validationItemProduct)
maka tidak perlu membuat variabel baru atau membuat parameter untuk mengakses variabel tersebut
sehingga dengan mudah membandingkan nilai di dalam fungsi dan variabel global tersebut
"""
# function for add items to database
def addItemProduct():
    system('clear')
    print("============== All Product ==================")
    global nameInput # Global variabel
    nameInput = input("Name Product : ")
    price = input("Price Product : ")
    stock = input("Stock Product : ")
    productSelected = list(filter(validationItemProduct, product))
    if not productSelected:
        product.append(dict(name=nameInput, price=price, stock=int(stock)))
        message("Product Added Successfully")
    else:
        productSelected[0]["stock"] += 1
        message("Stock product plus one")

"""" 
global nameInput 
nameInput merupakan variabel global yang dapat diakses di dalam method lain (validationItemProduct)
maka tidak perlu membuat variabel baru atau membuat parameter untuk mengakses variabel tersebut
sehingga dengan mudah membandingkan nilai di dalam fungsi dan variabel global tersebut
"""
# function for delete item
def deleteItemProduct():
    printAllProduct("seller")
    global nameInput # Global Variabel
    nameInput = input("Select name to delete : ")
    nameSelected = list(filter(validationItemProduct, product))
    if nameSelected:
        product.remove(nameSelected[0])
        message("Product Delete Successfully")
    else:
        message("Product not exist")

"""" 
global nameInput 
nameInput merupakan variabel global yang dapat diakses di dalam method lain (validationItemProduct)
maka tidak perlu membuat variabel baru atau membuat parameter untuk mengakses variabel tersebut
sehingga dengan mudah membandingkan nilai di dalam fungsi dan variabel global tersebut
"""
# function for update item
def updateItemProduct():
    value = ''
    printAllProduct("seller")
    global nameInput # Global Variabel
    nameInput = input("Select name to update : ")
    nameSelected = list(filter(validationItemProduct, product))
    if nameSelected:
        print("1. Update Name")
        print("2. Update Price")
        print("3. Update Stock")
        i = int(input("Select : "))
        if i == 1:
            value = input("New Name : ")
            nameSelected[0]["name"] = value
            message("Name Successfully Updated")
        elif i == 2:
            value = input("New Price : ")
            nameSelected[0]["price"] = value
            message("Price Successfully Updated")
        elif i == 3:
            value = input("New Stock : ")
            nameSelected[0]["stock"] = value
            message("Stock Successfully Updated")
        else:
            message("Wrong Input")
    else:
        message("Product no exist")



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
        message("Wrong input")

