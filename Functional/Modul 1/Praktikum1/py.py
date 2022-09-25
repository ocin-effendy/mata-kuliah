import getpass
import subprocess
admin = {"username": "admin", "password": "admin"}
user = []
books = [
    {
        "title": "The $100 Startup",
        "author": "Guillebeau Chris",
        "status": False
    },
    {
        "title": "Automic Habit",
        "author": "James Clear",
        "status": False
    },
    {
        "title": "Originals",
        "author": "Seth Godin",
        "status": False
    }
]

# Login Regist menu
def menu():
    loop = True
    while loop: 
        subprocess.call('reset')
        print("============ Perpustakaan Umum ============")
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
           messageError("Wrong Input") 


# validation data input user
def validationData(username, password):
    for i in user:
        if username in i and password in i:
            return True

# Message error
def messageError(message):
    print(message)
    input("enter")

# Login Page
def loginPage():
    subprocess.call('reset')
    print("============ Login Page ============") 
    username = input("Username : ")
    password = getpass.getpass("password : ")
    if username == admin["username"] and password == admin["password"]:
        menuAdmin()
    elif validationData(username, password):
        menuUser()
    else:
        messageError("User not found")
  

# Register Page
def registerPage():
    subprocess.call('reset')
    print("=========== Register Page ===========")
    username = input("Username : ")
    password = getpass.getpass("password : ")
    if validationData(username, password):
        messageError("user already exists!")
    else:
        user.append(list((username, password)))


# User menu after login
def menuUser():
    loop = True
    while loop:
        subprocess.call('reset')
        print("=========== Menu User ===========")
        print("1. List Books")
        print("2. Borrow a book")
        print("3. Log out")
        value = int(input("Select: "))
        if value == 1:
            printBooks()
            input("enter")
        elif value == 2:
            borrowTheBook()
        elif value == 3:
            loop = False
        else:
            messageError("Wrong Input")

# Print all books
def printBooks():
    index = 0
    print("\n============ All Books ===========")
    for i in books: 
        index += 1
        print("\n"+str(index))
        print("Title :" + i["title"])
        print("Author :" + i["author"])
        if i["status"]:
            print("Status : unavailable")
        else:
            print("Status : available")


# Borrow the book
def borrowTheBook():
    printBooks()
    value = int(input("\nSelect book : "))
    if value <= len(books):
        if books[value-1]["status"]:
            print("The book has been borrowed ")
        else:
            books[value-1]["status"] = True;
            print("Book borrowed successfully")
    else:
        print("Wrong Input")
    input("enter")

# Admin menu after login
def menuAdmin():
    loop = True
    while loop:
        subprocess.call('reset')
        print("=========== Menu User ============")
        print("1. List Books")
        print("2. Add a book")
        print("3. Log out")
        value = int(input("Select: "))
        if value == 1:
            printBooks()
            input("enter")
        elif value == 2:
            addBook()
        elif value == 3:
            loop = False
        else:
            messageError("Wrong Input")



# Add new book to list
def addBook():
    print("\nInput book")
    title = input("Title : ")
    author = input("Author : ")
    books.append(dict(title=title, author=author, status=False))
    print("Books Add Successfully")

menu()
