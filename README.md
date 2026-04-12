# 📋 CLI Task Manager

A simple command-line Task Manager built in Java.  
This is a learning project — built from scratch as part of my Java journey.

---

## 🚀 Features

- Add new tasks
- View all tasks with status (✓ / ✗)
- Mark tasks as completed
- Delete tasks
- Input validation and error handling

---

## 🛠️ Built With

- Java
- Scanner (user input)
- Arrays (data storage)

---

## ▶️ How to Run

**Requirements:** JDK 8 or higher

```bash
# Clone the repository
git clone https://github.com/NikosKatrakoulis/java-cli-taskmanager.git

# Navigate to the project folder
cd java-cli-taskmanager

# Compile
javac Main.java

# Run
java Main
```

---

## 📖 How to Use

When you run the program, you will see this menu:

```
===== MENU =====
1. Add a new task
2. View tasks
3. Complete task
4. Delete task
5. Quit
Choose one:
```

Enter the number of the action you want and follow the instructions.

---

## ⚠️ Limitations

- Tasks are stored in memory only — they are lost when the program closes
- Maximum 10 tasks at a time

---

## 🗺️ Roadmap

- [x] v0.1 — Static task list με println, variables, String concat
- [x] v0.2 — Scanner input, if/else menu, array[10], validation
- [ ] v0.3 — while(true) menu, methods, auto-numbering
- [ ] v0.4 — Classes (Task, TaskManager), ArrayList, save/load .txt

---

## 👨‍💻 About

I am learning Java from scratch.  
This project is updated weekly as I learn new concepts.

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
