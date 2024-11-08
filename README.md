# Tasklist

Tasklist is a colorful terminal-based program written in kotlin, which helps
with organizing and managing tasks, and saving them to a Json file.

## Stage 1/6: Read the list
What does a task manager need first? Well, tasks, obviously.

In this stage, the program, when executed, asks the user to input any number of tasks, and prints 
them out at the end with each task's number, with trailing and leading spaces removed. 
An empty line denotes the end of tasks.

[Open stage 1 on Hyperskill](https://hyperskill.org/projects/237/stages/1188/implement)

Stage implementation: [SimpleTasks.kt](app/src/main/kotlin/tasklist/SimpleTasks.kt)

**Example:** 

    Input the tasks (enter a blank line to end):
    >         Dentist on 15/1
    >    Buy book
    >     Change colors at site
    >
    1  Dentist on 15/1
    2  Buy book
    3  Change colors at site

## Stage 2/6 :The tasklist menu

In this stage, a menu is added to the program to help the user choose what they want. Also, it's now possible to adda a multi-line task.


[Open stage 2 on Hyperskill](https://hyperskill.org/projects/237/stages/1189/implement)

Stage implementation: [DeterminedTasks.kt](app/src/main/kotlin/tasklist/determinedTasks/DeterminedTasks.kt)

**Example:**

    Input an action (add, print, end):
    > add
    Input a new task (enter a blank line to end):
    > See my dentist on 14/1/22
    >
    Input an action (add, print, end):
    > add
    Input a new task (enter a blank line to end):
    > Supermarket
    > Chocolates, flour, oranges
    >
    Input an action (add, print, end):
    > add
    Input a new task (enter a blank line to end):
    > Buy book
    >
    Input an action (add, print, end):
    > add
    Input a new task (enter a blank line to end):
    > Change colors at site
    > Use Christmas theme
    >
    Input an action (add, print, end):
    > add
    Input a new task (enter a blank line to end):
    > Pay phone bill
    >
    Input an action (add, print, end):
    > add
    Input a new task (enter a blank line to end):
    > Pay water bill
    >
    Input an action (add, print, end):
    add
    Input a new task (enter a blank line to end):
    > Fix my printer
    >
    Input an action (add, print, end):
    > add
    Input a new task (enter a blank line to end):
    > Dentist on 15/1
    >
    Input an action (add, print, end):
    > add
    Input a new task (enter a blank line to end):
    > Cinema: get tickets
    > Check movie reviews
    >
    Input an action (add, print, end):
    > add
    Input a new task (enter a blank line to end):
    > Present for friend birthday
    >
    Input an action (add, print, end):
    > add
    Input a new task (enter a blank line to end):
    > Check new software
    >
    Input an action (add, print, end):
    > print
    1  See my dentist on 14/1/22
    
    2  Supermarket
    Chocolates, flour, oranges
    
    3  Buy book
    
    4  Change colors at site
    Use Christmas theme
    
    5  Pay phone bill
    
    6  Pay water bill
    
    7  Fix my printer
    
    8  Dentist on 15/1
    
    9  Cinema: get tickets
    Check movie reviews
    
    10 Present for friend birthday
    
    11 Check new software
    
    Input an action (add, print, end):
    > end
    Tasklist exiting!

## Stage 3/6: Date and time

Tasks are mote likely to be completed when they have a deadline and a priority. 

In this stage, it's possible to adda a date and time, and a priority to each task.

The priority is just one letter: **C**, **H**, **N**, **L** (case-insensitive) per task that stands for **Critical**, **High**, **Normal**, and **Low**, respectively.

Additionally, the program now takes care of inputting an empty task line, or a wrong date/time. In any of these cases, it'll 
prompt the user for a new input.


[Open stage 3 on Hyperskill](https://hyperskill.org/projects/237/stages/1190/implement)

Stage implementation: [PunctualTasks.kt](app/src/main/kotlin/tasklist/punctualTasks/PunctualTasks.kt)

**Example:**

    Input an action (add, print, end):
    > add
    Input the task priority (C, H, N, L):
    > n
    Input the date (yyyy-mm-dd):
    > 2021-12-23
    Input the time (hh:mm):
    > 24:00
    The input time is invalid
    Input the time (hh:mm):
    > 17:60
    The input time is invalid
    Input the time (hh:mm):
    > 9:15
    Input a new task (enter a blank line to end):
    > Supermarket
    >
    Input an action (add, print, end):
    > end
    Tasklist exiting!

## Stage 4/6: Edit the list

Sometimes we may need to modify or delete a task, right? That's what the program can now do in stage 4.

It's possible to edit the following fields of a task: priority, date, time, task(task lines)

In addition, a due tag is also added for each task, which will point out whether a task is overdue or not. 
This is just one letter — **I**, **T**, or **O** (case-insensitive). They stand for **In time**, **Today**, and **Overdue**.

To define the due tag, the program will compare the current date with the task date.

[Open stage 4 on Hyperskill](https://hyperskill.org/projects/237/stages/1191/implement)

Stage implementation: [TaskManager.kt](app/src/main/kotlin/tasklist/taskManager/TaskManager.kt)

**Example:** normal execution (current day — 2024-11-8)

    Input an action (add, print, edit, delete, end):
    > add
    Input the task priority (C, H, N, L):
    > h
    Input the date (yyyy-mm-dd):
    > 2021-12-25
    Input the time (hh:mm):
    > 14:00
    Input a new task (enter a blank line to end):
    > Christmas meal
    >
    Input an action (add, print, edit, delete, end):
    > add
    Input the task priority (C, H, N, L):
    > N
    Input the date (yyyy-mm-dd):
    > 2024-11-8
    Input the time (hh:mm):
    > 19:15
    Input a new task (enter a blank line to end):
    > Dentist
    >
    Input an action (add, print, edit, delete, end):
    > add
    Input the task priority (C, H, N, L):
    > L
    Input the date (yyyy-mm-dd):
    > 2024-11-10
    Input the time (hh:mm):
    > 19:00
    Input a new task (enter a blank line to end):
    > Supermarket
    > -----------
    > Pasta
    > Butter
    > Cheese
    >
    Input an action (add, print, edit, delete, end):
    > print
    1  2021-12-25 14:00 H O
    Christmas meal
    
    2  2024-11-08 19:15 N T
    Dentist
    
    3  2024-11-10 19:00 L I
    Supermarket
       -----------
    Pasta
    Butter
    Cheese
    
    Input an action (add, print, edit, delete, end):
    > end
    Tasklist exiting!

## Stage 5/6: Frame and colors

Everything looks good with some colors.

In this stage, our program is upgraded from a plain text task manager, to one with design and colors.

A task's priority and due tag are represented by defined colors, as follows:

###### Priority colors:

 - C (Critical): Red
 - H (High): Yellow
 - N (Normal): Green
 - L (Low): Cyan

###### Due tag colors:

- I (In-time): Green
- T (Today): Yellow
- O (Overdue): Red

[Open stage 5 on Hyperskill](https://hyperskill.org/projects/237/stages/1192/implement)

Stage implementation: [PunctualTasks.kt](app/src/main/kotlin/tasklist/colorfultasks/ColorfulTaskManager.kt)

**Example:** normal execution (current day 2024-11-9)

    Input an action (add, print, edit, delete, end):
    > add
    Input the task priority (C, H, N, L):
    > N
    Input the date (yyyy-mm-dd):
    > 2024-11-9
    Input the time (hh:mm):
    > 19:00
    Input a new task (enter a blank line to end):
    > Supermarket
    > milk
    > cookies
    > butter
    >
    Input an action (add, print, edit, delete, end):
    > add
    Input the task priority (C, H, N, L):
    > C
    Input the date (yyyy-mm-dd):
    > 2024-11-20
    Input the time (hh:mm):
    > 20:15
    Input a new task (enter a blank line to end):
    > Dentist
    >
    Input an action (add, print, edit, delete, end):
    > add
    > Input the task priority (C, H, N, L):
    L
    Input the date (yyyy-mm-dd):
    > 2024-11-1
    Input the time (hh:mm):
    > 12:00
    Input a new task (enter a blank line to end):
    > Buy book
    >
    Input an action (add, print, edit, delete, end):
    > add
    Input the task priority (C, H, N, L):
    > H
    Input the date (yyyy-mm-dd):
    > 2024-11-15
    Input the time (hh:mm):
    > 00:00
    Input a new task (enter a blank line to end):
    > Pay bills
    >
    Input an action (add, print, edit, delete, end):
    > print

Prints the following:
<img width="493" alt="output" src="https://github.com/user-attachments/assets/def1daf2-50f1-470b-85f3-30d811604b02">

