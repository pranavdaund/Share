# SUBJECT 1: OPERATING SYSTEMS
## Session 1 — Topic 1: Introduction to Operating System

**Priority: 🔴 HIGH PRIORITY** (Foundation topic — almost every CCEE paper has 2–5 questions directly or indirectly from this)

---

## 1.1 What is an Operating System (OS)?

**Definition:**
An Operating System is **system software** that acts as an **intermediary (interface)** between the **computer hardware** and the **user/application programs**. It manages hardware resources (CPU, memory, I/O devices, files) and provides a convenient, efficient environment for programs to execute.

Think of it as a **"government"** of the computer system — it doesn't do productive work itself but creates an environment in which other programs (citizens) can do useful work.

**Two main goals of an OS:**
1. **Convenience** — make the computer easy to use.
2. **Efficiency** — use hardware resources (CPU, memory, disk) efficiently.
3. (Sometimes a 3rd goal is added) **Ability to evolve** — new features can be added without disturbing existing services.

```
 ┌─────────────────────────────┐
 │      Application Software   │  (MS Word, Chrome, Games)
 ├─────────────────────────────┤
 │      Operating System       │  (Windows, Linux, Android)
 ├─────────────────────────────┤
 │         Hardware            │  (CPU, RAM, Disk, I/O)
 └─────────────────────────────┘
```

**Exam Tip 🎯:** If asked "OS is a resource manager or a control program?" — answer is **BOTH**. It manages resources (CPU, memory) AND controls execution of programs (control program) to prevent errors and improper use.

---

## 1.2 How is OS different from other Application Software?

| Point | Operating System (System Software) | Application Software |
|---|---|---|
| Purpose | Manages hardware & provides platform for other software | Performs specific user tasks |
| Dependency | Loads first; other software runs on top of it | Depends on OS to run |
| Access to hardware | Direct access (privileged/kernel mode) | Indirect access (via OS system calls) |
| Examples | Windows, Linux, macOS, Android | MS Excel, Photoshop, Chrome |
| When installed | Installed first on a bare machine | Installed after OS is present |
| Runs in | Kernel mode + User mode | Only User mode |

**Key concept:** OS is the **only software that runs in privileged (kernel) mode** by default; application software always runs in user mode and must request OS services via **system calls** to access hardware.

**Frequently Confused Point ⚠️:** Students often think "system software = OS only." Actually, system software is a broader category that includes OS, **compilers, assemblers, linkers, loaders, device drivers, utility programs** — OS is the most important system software, but not the only one.

---

## 1.3 Why is OS hardware dependent?

**Definition/Concept:**
Large parts of the OS (especially the **kernel**, device drivers, and the part that handles interrupts) are written keeping a **specific hardware architecture (CPU instruction set, memory management unit, I/O controllers)** in mind. This is why:

- Windows compiled for x86 doesn't run on ARM without modification/emulation.
- The OS must know the exact CPU instructions to switch between user mode and kernel mode.
- Device drivers are hardware-specific (a printer driver for Printer A won't work for Printer B).
- Interrupt handling mechanisms depend on the interrupt controller hardware.

**However:** Modern OS designs try to minimize this dependency using a **layered/microkernel approach**, where only a small **Hardware Abstraction Layer (HAL)** is hardware-specific, and the rest of the OS is written in portable, high-level code (mostly C).

**Real-life example:** You cannot install a normal Windows ISO on an Android smartphone directly, because the CPU architecture (ARM vs x86) and hardware are different — even though both are "OS" conceptually.

**Exam Tip 🎯:** A very common one-liner CCEE question: *"Which part of the OS is hardware-dependent?"* → **Kernel / HAL / Device Drivers**. The **shell/user interface** part is largely hardware-independent.

---

## 1.4 Different Components of OS

An OS is generally divided into major components/subsystems, each managing one aspect:

```
        ┌────────────────────────────┐
        │   1. Process Management    │
        ├────────────────────────────┤
        │   2. Memory Management     │
        ├────────────────────────────┤
        │   3. File Management       │
        ├────────────────────────────┤
        │   4. I/O (Device) Mgmt     │
        ├────────────────────────────┤
        │   5. Secondary Storage Mgmt│
        ├────────────────────────────┤
        │   6. Security & Protection │
        ├────────────────────────────┤
        │   7. Networking            │
        ├────────────────────────────┤
        │   8. Command Interpreter/  │
        │      User Interface (Shell)│
        └────────────────────────────┘
```

1. **Process Management** — creation, scheduling, termination, synchronization of processes.
2. **Memory Management** — allocation/deallocation of main memory to processes.
3. **File Management** — creation, deletion, reading, writing, organizing files/directories.
4. **I/O Device Management** — controls and coordinates use of I/O devices via drivers.
5. **Secondary Storage Management** — disk space allocation, disk scheduling, free space management.
6. **Protection & Security** — controls access to resources; user authentication.
7. **Networking (Distributed systems)** — enables communication between systems.
8. **Command Interpreter / Shell** — interface for user to give commands to OS (CLI or GUI).

**Short Trick to remember (Mnemonic):** **"PM-MFI-SS-P-N-C"** → *"Please Manage My Files In Secure Systems, Properly Network & Command"*
(Process, Memory, File, I/O, Secondary Storage, Protection, Networking, Command Interpreter)

**Common Mistake ❌:** Students confuse **File Management** and **Secondary Storage Management**. 
- File management = logical view (file names, directories, permissions).
- Secondary storage management = physical view (disk blocks, free space, disk scheduling algorithms like SSTF, SCAN).

---

## 1.5 Basic Computer Organization required for OS

To understand OS, you must know the basic hardware building blocks it manages:

```
   ┌─────────┐     System Bus      ┌──────────┐
   │   CPU   │◄───────────────────►│  Memory  │
   └─────────┘                     └──────────┘
        ▲
        │ Interrupts / I/O Bus
        ▼
   ┌───────────────────────────────────┐
   │  I/O Devices (Disk, Keyboard,      │
   │  Printer, Network Card, etc.)      │
   └───────────────────────────────────┘
```

**Key hardware components an OS must manage:**
- **CPU (Central Processing Unit):** Has registers (PC – Program Counter, IR – Instruction Register, SP – Stack Pointer), ALU, and Control Unit. Executes instructions in a **fetch-decode-execute cycle**.
- **Memory (RAM):** Volatile storage; CPU can directly access it. Organized as an array of bytes, each with an address.
- **I/O Devices & Controllers:** Each device has a local buffer, registers, and a **device controller**. The device controller communicates with the device driver (part of OS).
- **Bus:** Communication pathway between CPU, memory, and I/O devices.
- **Interrupt mechanism:** Hardware line that lets devices signal the CPU asynchronously (explained in detail in 1.8 below).
- **Timer/Clock:** Special hardware used by OS to prevent a process from monopolizing the CPU (used in preemptive scheduling).
- **DMA (Direct Memory Access) Controller:** Allows I/O devices to transfer data to/from memory **without CPU intervention** for every byte — improves efficiency for bulk data transfer (e.g., disk transfers).

**Exam Tip 🎯:** DMA is a favorite CCEE MCQ topic: *"Which hardware unit reduces CPU overhead during I/O by directly transferring data to memory?"* → **DMA Controller**.

---

## 1.6 Examples of well-known OS (and how they differ)

| Type of OS | Examples | Key Characteristic | Typical Use |
|---|---|---|---|
| **Desktop OS** | Windows, macOS, Linux (Ubuntu) | General-purpose, GUI-based, multitasking | Personal computers |
| **Server OS** | Windows Server, Linux (RHEL, CentOS), Unix | Optimized for handling many simultaneous requests, high uptime, security | Web servers, database servers |
| **Mobile OS** | Android, iOS | Touch-based, power-efficient, app-sandboxing | Smartphones, tablets |
| **Embedded System OS** | Embedded Linux, VxWorks, TinyOS | Small footprint, runs on limited hardware, dedicated single function | Washing machines, ATMs, routers |
| **Real-Time OS (RTOS)** | VxWorks, QNX, FreeRTOS | Guarantees response within a strict, predictable time limit (deadline) | Pacemakers, missile guidance, robotics, car airbags |

**Why are they different?**
- **Desktop/Server OS** focus on **throughput, fairness, resource sharing** among many users/processes.
- **Mobile OS** focus on **battery life, touch UI, app isolation (sandboxing)**.
- **Embedded OS** focus on **minimal resource usage** (limited RAM/ROM) since hardware is fixed and small.
- **RTOS** focuses on **predictability/determinism** — meeting deadlines matters MORE than average speed.

**RTOS sub-types (important MCQ point):**
- **Hard Real-Time:** Missing a deadline = catastrophic failure (e.g., airbag system, nuclear reactor control).
- **Soft Real-Time:** Missing deadline degrades quality but system still works (e.g., video streaming, online gaming).

**Frequently Confused Point ⚠️:** RTOS is NOT about being "fast." A RTOS may even be slower than a desktop OS in raw speed, but it is **predictable/deterministic** — it guarantees a task finishes within a fixed time bound.

**Exam Tip 🎯:** A very popular CCEE question: *"Give an example of hard real-time system"* → **Airbag deployment system, pacemaker, missile control** (NOT online booking or video streaming — those are soft real-time).

---

## 1.7 Functions of OS

Core functions (this overlaps with "components" above but exam-wise it is often asked as "Functions"):

1. **Process Management** — create, schedule, terminate processes; CPU scheduling.
2. **Memory Management** — keep track of which part of memory is used by whom; allocate/deallocate memory.
3. **File & Storage Management** — organize, name, protect, and access files.
4. **I/O System Management** — hide hardware peculiarities from user using device drivers.
5. **Protection and Security** — control access to system resources; prevent unauthorized access.
6. **User Interface** — provide CLI (Command Line Interface) or GUI (Graphical User Interface).
7. **Error Detection** — detect and, where possible, correct errors in CPU, memory, I/O devices.
8. **Resource Allocation** — allocate resources (CPU time, memory, files, I/O) among multiple users/jobs.
9. **Accounting** — keep track of which users use how much and what kind of resources (used for billing/statistics in multi-user systems).
10. **Job/Program Execution** — load programs into memory and execute them.

**Short Trick (Mnemonic):** **"PM FIRE UP A Job"** → Process, Memory, File, I/O, Resource allocation, Error detection, User interface, Protection, Accounting, Job execution.

---

## 1.8 User Space & Kernel Space; User Mode & Kernel Mode

This is one of the **MOST IMPORTANT** and **most frequently tested** concepts in OS.

**Definition:**
Modern CPUs support (at least) **two modes of operation** to protect the OS and hardware from faulty/malicious user programs:

| Mode | Also called | Access Level | Who runs here |
|---|---|---|---|
| **User Mode** | Restricted mode | Limited — cannot directly access hardware or critical instructions | Application programs |
| **Kernel Mode** | Supervisor mode / Privileged mode | Full — can execute any instruction, access all memory and hardware | OS kernel |

**How it works (Mode bit):**
- A **mode bit** in a hardware register indicates current mode: **0 = kernel mode, 1 = user mode** (this exact convention is a classic CCEE MCQ).
- When a user program needs a privileged operation (like reading a file, allocating memory), it cannot do it directly. It must make a **system call**, which switches the CPU from user mode → kernel mode, lets the OS perform the operation safely, then switches back to user mode.

```
   USER MODE                    KERNEL MODE
 ┌─────────────┐   system call ┌──────────────┐
 │ Application │ ────────────► │   OS Kernel   │
 │  (mode=1)   │                │  (mode=0)     │
 │             │ ◄──────────── │  performs task │
 └─────────────┘   return       └──────────────┘
```

**Why is this separation needed?**
- **Protection:** Prevents a user program from directly manipulating hardware or other processes' memory, which could crash the system or breach security.
- **Stability:** If a user program crashes, it does NOT bring down the whole OS (because it can't touch kernel memory).

**Real-life example:** A word processor (user mode) wants to save a file to disk. It cannot directly command the disk controller. It calls the `write()` system call → CPU switches to kernel mode → OS kernel talks to the disk driver → data written → control returns to user mode.

**Common Mistake ❌:** Students think "kernel mode is slower." Actually kernel mode is not inherently slower — it's about **privilege**, not speed. The switching (context switch overhead) does cost time though.

**Exam Tip 🎯:** Remember — **only kernel mode can execute privileged instructions** like: halting the CPU, changing the mode bit, I/O instructions, setting timer, clearing memory, disabling interrupts. If a user program tries to execute these directly → **Trap (a type of interrupt) → OS terminates the program (illegal instruction error)**.

---

## 1.9 Interrupts and System Calls

### A) Interrupts

**Definition:** An **interrupt** is a signal sent to the CPU by hardware or software indicating an event that needs **immediate attention**, causing the CPU to temporarily suspend its current activity, save its state, and execute a special routine called the **Interrupt Service Routine (ISR)** / interrupt handler.

**Types of Interrupts:**

```
                    INTERRUPTS
                        │
      ┌─────────────────┼──────────────────┐
      │                  │                  │
 HARDWARE           SOFTWARE            TRAP/EXCEPTION
 INTERRUPT          INTERRUPT           
 (from devices      (system call –      (error caused by
  like keyboard,     program requests    program itself:
  mouse, disk,       OS service)         divide by zero,
  timer)                                 illegal memory access)
```

1. **Hardware Interrupt** — generated by external devices (keyboard press, mouse click, timer expiry, I/O completion). E.g., pressing a key generates an interrupt so CPU can stop what it's doing and process the keystroke.
2. **Software Interrupt (Trap)** — deliberately caused by a program, typically via a **system call instruction** to request OS service.
3. **Exception** — caused by an error during instruction execution (e.g., divide by zero, invalid memory access, arithmetic overflow) — also called a trap in many texts.

**Interrupt Handling Steps (Important – draw this as a flow in exam):**
```
1. Device/program raises interrupt signal
2. CPU finishes current instruction, checks interrupt line
3. CPU saves current state (PC, registers) onto stack / PCB
4. CPU looks up Interrupt Vector Table (IVT) to find address of ISR
5. CPU jumps to and executes the ISR (Interrupt Service Routine)
6. After ISR completes, CPU restores saved state
7. CPU resumes the interrupted program
```

**Key term — Interrupt Vector / Interrupt Vector Table (IVT):** A table containing addresses (pointers) of interrupt handler routines, indexed by interrupt type/number, so CPU knows exactly where to jump for each interrupt type — this makes interrupt handling **fast** (no need to search).

**Exam Tip 🎯:** *"Why do modern OS use interrupt-driven architecture instead of polling?"* → **Efficiency**: In polling, CPU repeatedly checks device status wasting CPU cycles; in interrupt-driven I/O, CPU does other work and is only "interrupted" when device is actually ready — much more efficient.

### B) System Calls

**Definition:** A **system call** is the **programming interface (API)** through which a user program requests a service from the OS kernel — e.g., to create a file, allocate memory, create a process, or communicate with a device.

**Why needed:** User programs run in user mode and have no direct access to hardware/kernel data structures. System calls are the *only* legitimate gateway into kernel mode.

**Categories of System Calls (very important — commonly asked to classify an example):**

| Category | Purpose | Examples |
|---|---|---|
| **Process Control** | create, terminate, wait for processes | `fork()`, `exec()`, `exit()`, `wait()` |
| **File Management** | create, delete, read, write files | `open()`, `read()`, `write()`, `close()` |
| **Device Management** | request/release device, read/write device | `ioctl()`, `read()`, `write()` |
| **Information Maintenance** | get/set system data, time, date | `getpid()`, `time()` |
| **Communication** | inter-process communication | `pipe()`, `shmget()`, `send()`, `recv()` |
| **Protection** | control access to resources | `chmod()`, `chown()` |

**How a system call works (step-by-step, common diagram question):**
```
User Program
    │  calls e.g. read()
    ▼
Library function (wrapper) in User space
    │  places system call number in a register
    │  executes special TRAP instruction
    ▼
--------- MODE SWITCH (user → kernel) ---------
    ▼
Kernel checks system call number in
"System Call Table" → jumps to correct
kernel function → executes it
    ▼
--------- MODE SWITCH (kernel → user) ---------
    ▼
Control + result returned to User Program
```

**Real-life Example:** When you run `printf("Hello")` in C, internally the library eventually calls the `write()` system call to actually display output on screen — this requires kernel mode because writing to the screen device needs hardware access.

**Frequently Confused Point ⚠️:**
| System Call | Function Call (normal) |
|---|---|
| Switches CPU mode (user → kernel → user) | No mode switch; stays in user mode |
| Provides access to OS/hardware services | Just executes program logic |
| Slower (context switch overhead) | Faster |
| Examples: `read()`, `fork()` | Examples: your own `add(a,b)` function |

**Common Mistake ❌:** Confusing **interrupt** and **system call**. 
- **Interrupt** = triggered by hardware/asynchronous event (external, unplanned).
- **System call** = triggered deliberately by a running program (synchronous, planned) — technically implemented USING a software interrupt/trap instruction.
So: *"All system calls use a trap/interrupt mechanism, but not all interrupts are system calls."*

**Exam Tip 🎯:** A trap is a **software-generated interrupt** — caused either by an **error** (exception) or by a **user request for OS service** (system call). This exact line is a favorite one-mark MCQ/fill-in-blank in CCEE.

---

# 📝 QUICK REVISION NOTES (1-Page Summary)

- **OS** = interface between user/application and hardware; goals = convenience + efficiency.
- **OS components:** Process, Memory, File, I/O, Secondary Storage, Protection, Networking, Command Interpreter mgmt.
- **Hardware basics:** CPU (fetch-decode-execute), Memory, I/O controllers, Bus, Interrupt line, Timer, DMA controller.
- **OS types:** Desktop, Server, Mobile, Embedded, RTOS (Hard/Soft) — differ in goals: throughput vs battery vs footprint vs determinism.
- **Functions of OS:** Resource allocation, error detection, protection, accounting, UI, execution of programs.
- **Dual mode:** User mode (mode bit=1) vs Kernel mode (mode bit=0); privileged instructions only in kernel mode.
- **Interrupts:** Hardware interrupt, Software interrupt (trap), Exception. Handled via Interrupt Vector Table.
- **System calls:** Interface for user program to request kernel service; causes mode switch; categories = Process control, File mgmt, Device mgmt, Info maintenance, Communication, Protection.
- **Trap** = software interrupt = used for both system calls and exceptions/errors.

---

# ✅ MCQs (20 Questions with Answers & Explanations)

**Q1.** The main purpose of an Operating System is to:
a) Increase hardware cost b) Act as an interface between user and hardware c) Replace application software d) Write compilers
**Answer: b** — OS acts as intermediary between hardware and user/application programs.

**Q2.** Which of the following is NOT a function of the Operating System?
a) Memory management b) Process management c) Compiling high-level source code d) File management
**Answer: c** — Compiling is done by a compiler (system software, but not OS itself).

**Q3.** The mode bit is set to 0 to indicate:
a) User mode b) Kernel mode c) Idle mode d) Sleep mode
**Answer: b** — Convention: 0 = kernel(monitor) mode, 1 = user mode.

**Q4.** Which hardware component allows I/O devices to transfer data directly to/from memory without CPU involvement for each byte?
a) ALU b) DMA controller c) Cache d) Register
**Answer: b** — DMA (Direct Memory Access) reduces CPU overhead in bulk transfers.

**Q5.** A Real-Time OS used in an airbag deployment system is an example of:
a) Soft real-time system b) Hard real-time system c) Batch system d) Time-sharing system
**Answer: b** — Missing the deadline = catastrophic; hence hard real-time.

**Q6.** Video streaming applications are examples of:
a) Hard real-time system b) Soft real-time system c) Batch system d) None of these
**Answer: b** — A missed deadline (buffering) degrades quality but doesn't cause catastrophic failure.

**Q7.** System calls are typically invoked using:
a) A polling loop b) A trap/software interrupt instruction c) Direct hardware access d) DMA
**Answer: b** — System calls use a trap instruction to switch to kernel mode.

**Q8.** Which of these is a process control system call?
a) open() b) fork() c) read() d) chmod()
**Answer: b** — fork() creates a new process (process control category).

**Q9.** What triggers a hardware interrupt?
a) A user pressing a key b) A divide-by-zero error c) A system call d) A compiler
**Answer: a** — Keyboard press is an external hardware event.

**Q10.** Divide-by-zero error is classified as a:
a) Hardware interrupt b) Exception/Trap c) System call d) DMA request
**Answer: b** — It's an error during execution → exception (a type of trap).

**Q11.** The table containing addresses of Interrupt Service Routines is called:
a) Page table b) Interrupt Vector Table c) System call table d) File allocation table
**Answer: b** — IVT maps interrupt numbers to handler addresses.

**Q12.** Which of the following runs only in User Mode?
a) Kernel b) Device driver core routines c) Application software d) Interrupt handler
**Answer: c** — Application programs run in user mode; drivers/kernel run in kernel mode.

**Q13.** Interrupt-driven I/O is preferred over polling because:
a) It is simpler to code b) It saves CPU cycles by avoiding continuous status checks c) It uses less memory d) It avoids using system calls
**Answer: b** — CPU does other work instead of continuously checking device status.

**Q14.** Which is an example of an Embedded OS?
a) Windows Server b) VxWorks used in a washing machine c) Ubuntu Desktop d) iOS on iPhone
**Answer: b** — Embedded OS runs dedicated functions on limited hardware.

**Q15.** Which OS component manages disk block allocation and disk scheduling?
a) File management b) Secondary storage management c) Process management d) Memory management
**Answer: b** — Deals with physical disk space, not logical file view.

**Q16.** Which of the following statements is TRUE about kernel mode?
a) It is always slower than user mode by design b) Only privileged instructions can execute here c) Application programs run directly in kernel mode d) It has no access to hardware
**Answer: b** — Kernel mode allows execution of privileged/protected instructions.

**Q17.** A system call that creates a new file belongs to which category?
a) Process control b) File management c) Device management d) Communication
**Answer: b**

**Q18.** Why is a large part of the OS hardware-dependent?
a) Because OS is written only in assembly b) Because kernel & drivers interact directly with specific hardware architecture c) Because compilers require it d) Because of file systems only
**Answer: b**

**Q19.** Which of these is TRUE?
a) All interrupts are system calls b) All system calls are interrupts (traps) but not all interrupts are system calls c) System calls never cause mode switch d) Traps are only hardware generated
**Answer: b** — Core exam concept explained above.

**Q20.** The timer/clock hardware in a computer is primarily used by OS to:
a) Display time to user only b) Prevent a process from monopolizing the CPU (preemption) c) Manage files d) Perform DMA transfer
**Answer: b** — Timer interrupt enables preemptive scheduling.

---

# 💬 Conceptual Questions (3–5)

1. Explain why an Operating System needs to operate in two distinct modes (user and kernel). What would happen if this separation didn't exist?
2. Differentiate between a hardware interrupt, a software interrupt (trap), and an exception, with one real-life example of each.
3. Explain the step-by-step sequence of events that occur when a user program executes a `read()` system call to read data from a file.
4. Why is a Real-Time OS not necessarily "faster" than a general-purpose Desktop OS? Justify with an example.
5. List and briefly explain any 5 major components/functions of an Operating System.

---

# 💻 Coding-related Questions (2)

**Q1.** Write a simple C program that demonstrates the use of the `fork()` system call to create a child process, and explain (in comments) which part executes in the parent and which in the child.

```c
#include <stdio.h>
#include <unistd.h>

int main() {
    pid_t pid = fork();   // system call: mode switch happens here internally

    if (pid < 0) {
        printf("Fork failed\n");
    } else if (pid == 0) {
        // This block executes in the CHILD process
        printf("Child process, PID = %d\n", getpid());
    } else {
        // This block executes in the PARENT process
        printf("Parent process, Child PID = %d\n", pid);
    }
    return 0;
}
```
*Explanation:* `fork()` is a **process control system call**. It causes the CPU to switch to kernel mode, duplicate the calling process, then return control to both parent (returns child's PID) and child (returns 0) in user mode.

**Q2.** Write a C program showing how a `write()` system call is used to print output directly (bypassing the standard library buffer), and explain why this is a system call and not a normal function call.

```c
#include <unistd.h>

int main() {
    char msg[] = "Hello from a system call!\n";
    write(1, msg, sizeof(msg) - 1);   // 1 = file descriptor for stdout
    return 0;
}
```
*Explanation:* `write()` directly invokes the kernel to output data to the device (screen). Unlike a normal function, it triggers a **mode switch from user to kernel mode** because only the kernel can access the actual output device/hardware.

---

✅ **This completes Session 1 – Topic: Introduction to Operating System.**

Type **"Next"** to continue to the next topic in the syllabus.
