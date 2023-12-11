<br />
<p align="center">
  <h1 align="center">Car Wash Schedule</h1>

  <p align="center">
    Schedule program that keeps track of cars that enter a car wash and are being served using a voucher system 
  </p>
</p>

## Table of Contents

* [About the Project](#about-the-project)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
  * [Running](#running)
* [Modules](#modules)
* [Evaluation](#evaluation)

## About The Project

The Car Wash Schedule Simulation Project is an application developed using Object-Oriented Programming (OOP) principles in Java. This innovative program emulates a dynamic car wash system, incorporating classes such as Customer, MemberQueue, Voucher, and VoucherStack to efficiently manage and simulate the car washing process.

The heart of the simulation revolves around the utilization of Linked List-based Stacks and Queues to meticulously track the arrival of cars, their wait times, and the availability of queue spaces. The OutLine queue stores details of customers scheduled for the current day, including their arrival time, ID, name, and service preferences indicated by a service code.

Upon arrival, customers enter the InLine queue, provided there is space available, and await their turn for service. The program ensures a realistic simulation, considering factors such as queue dynamics, ongoing service, and immediate commencement for the first customer in line.

As cars complete their services, they exit the InLine queue, making room for the next in line. The program meticulously prints details of each action, providing the developer with a comprehensive understanding of the car wash process, from entry to service completion.

Customers receive vouchers with service codes representing their chosen services, including wash, wax, and vacuum. They have the flexibility to opt for one, two, or all three services. The program employs a stack to manage these vouchers, and a lowly minion periodically collects and prints them, following the Last-In-First-Out (LIFO) principle.

Notably, the lowly minion, identified by the unique Z code, operates independently and does not occupy a place in the queue. At the close of the car wash day at 4 PM, the lowly minion systematically collects all remaining vouchers from the stack, offering a final summary of the day's activities.

In essence, this project provides a comprehensive and realistic simulation of a car wash schedule, employing OOP design principles and data structures to model a dynamic and efficient car wash management system.

## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or higher

### Installation

1. Download all 5 java files
2. Run the program.
3. (Optional) - run the sample file found on the Github project page

### Running

List of Commands:     
The number in the first line (x) is the max number of customers in the wash queue       
The number on the second line (y) is the number of days the car wash will work      
-----This is followed by y input days        
The 3 numbers on the third line are the cost of a wash, wax and a vacuum in that particular day      
The number on the forth line (n) is the number of clients expected in that day followed by that number of clients        
-----This is followed by n lines of input representing the customers along with their arrival time and other details      

## Modules

## Evaluation

The Car Wash Schedule Simulation Project currently maintains a stable and functional implementation, showcasing the effective application of Object-Oriented Programming (OOP) principles in Java. The use of Linked List-based Stacks and Queues has proven reliable, accurately modeling the dynamic aspects of the car wash process.

Throughout testing, the program has exhibited stability without apparent bugs, and the detailed event printing contributes to a transparent view of system behavior. While the current design meets project objectives, there is always room for modest enhancements and additional features.

Given more time, one area of improvement could be the refinement of the user interface for increased user-friendliness. A more intuitive interface could enhance the overall user experience, making the simulation more accessible and engaging. Additionally, the implementation might benefit from the incorporation of robust error-handling mechanisms to gracefully manage unexpected scenarios, ensuring the program's resilience in diverse situations.

Feature-wise, potential new additions might include a statistical analysis module, providing insights into overall system performance, average wait times, or popular service choices. This could offer a more in-depth understanding of the simulated car wash operations. Another consideration could be the integration of a configuration module, allowing users to customize simulation parameters such as operating hours, queue capacities, or service durations.

While the current project design is effective, these modest suggestions aim to explore avenues for improvement, maintaining the project's stability while introducing additional user-centric features and analytical capabilities.



<!-- Below you can find some sections that you would normally put in a README, but we decided to leave out (either because it is not very relevant, or because it is covered by one of the added sections) -->

<!-- ## Usage -->
<!-- Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources. -->

<!-- ## Roadmap -->
<!-- Use this space to show your plans for future additions -->

<!-- ## Contributing -->
<!-- You can use this section to indicate how people can contribute to the project -->

<!-- ## License -->
<!-- You can add here whether the project is distributed under any license -->


<!-- ## Contact -->
<!-- If you want to provide some contact details, this is the place to do it -->

<!-- ## Acknowledgements  -->

