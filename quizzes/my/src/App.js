import React, { useState, useEffect } from 'react';
import { initializeApp } from 'firebase/app';
import { getAuth, signInAnonymously, signInWithCustomToken, onAuthStateChanged } from 'firebase/auth';
import { getFirestore, collection, addDoc, query, onSnapshot, orderBy, serverTimestamp } from 'firebase/firestore';

// Global variables provided by the Canvas environment
const appId = "1:929757852715:web:b9756501433b4bdccf266e";
const firebaseConfig = {
  apiKey: "AIzaSyBx1xKqUMFvSVVcBLl1g1BTbj8qKVBml34",
  authDomain: "quizz-81ab1.firebaseapp.com",
  projectId: "quizz-81ab1",
  storageBucket: "quizz-81ab1.firebasestorage.app",
  messagingSenderId: "929757852715",
  appId: "1:929757852715:web:b9756501433b4bdccf266e",
  measurementId: "G-NHBDZZF1QN"
};
const initialAuthToken = typeof __initial_auth_token !== 'undefined' ? __initial_auth_token : null;

// Ensure Tailwind CSS is loaded
const loadTailwind = () => {
  if (!document.querySelector('script[src="https://cdn.tailwindcss.com"]')) {
    const script = document.createElement('script');
    script.src = 'https://cdn.tailwindcss.com';
    document.head.appendChild(script);
  }
};

loadTailwind();

function App() {
  const [db, setDb] = useState(null);
  const [auth, setAuth] = useState(null);
  const [userId, setUserId] = useState(null);
  const [quizzes, setQuizzes] = useState([]);
  const [loading, setLoading] = useState(true);
  const [message, setMessage] = useState('');

  // Sample quiz data from the last interaction
  const lastQuizResult = {
    quizTitle: "Java Constructors MCQs for Freshers",
    score: "30/40",
    answeredQuestions: [
      {
        question: "Which keyword is used to call a constructor from another constructor in the same class?",
        correctAnswer: "this",
        userAnswer: "this",
        userIsCorrect: true
      }, {
        question: "What is the primary purpose of a Java constructor?",
        correctAnswer: "To initialize the state of an object.",
        userAnswer: "To initialize the state of an object.",
        userIsCorrect: true
      }, {
        question: "Can a Java constructor be abstract?",
        correctAnswer: "No, constructors cannot be abstract.",
        userAnswer: "Yes, if the class is abstract.",
        userIsCorrect: false
      }, {
        question: "Which of the following statements about constructors is true?",
        correctAnswer: "A class can have multiple constructors.",
        userAnswer: "A class can have multiple constructors.",
        userIsCorrect: true
      }, {
        question: "What is a default constructor in Java?",
        correctAnswer: "A constructor automatically provided by the compiler if no other constructors are defined.",
        userAnswer: "A constructor automatically provided by the compiler if no other constructors are defined.",
        userIsCorrect: true
      }, {
        question: "Can a Java constructor be `static`?",
        correctAnswer: "No, constructors cannot be static.",
        userAnswer: "No, constructors cannot be static.",
        userIsCorrect: true
      }, {
        question: "Which access modifier can be used with a constructor?",
        correctAnswer: "`public`, `private`, `protected`, and default (package-private).",
        userAnswer: "`public`, `private`, `protected`, and default (package-private).",
        userIsCorrect: true
      }, {
        question: "Consider the following Java code: \n```java\nclass MyClass {\n    int x;\n    public MyClass(int x) {\n        this.x = x;\n    }\n    public MyClass() {\n        this(10);\n    }\n}\n```\nWhat will be the value of `x` when `new MyClass()` is called?",
        correctAnswer: "`10`",
        userAnswer: "`10`",
        userIsCorrect: true
      }, {
        question: "If a class does not define any constructors, what happens when an object of that class is created?",
        correctAnswer: "The Java compiler provides a default (no-argument) constructor.",
        userAnswer: "The Java compiler provides a default (no-argument) constructor.",
        userIsCorrect: true
      }, {
        question: "Can a constructor call a method of the same class?",
        correctAnswer: "Yes, both static and non-static methods.",
        userAnswer: "No, constructors are only for initialization.",
        userIsCorrect: false
      }, {
        question: "What is constructor overloading in Java?",
        correctAnswer: "Defining multiple constructors in the same class with different parameter lists.",
        userAnswer: "Defining multiple constructors in the same class with different parameter lists.",
        userIsCorrect: true
      }, {
        question: "Which of the following is true about `super()` and `this()` in constructors?",
        correctAnswer: "`super()` must be the first statement in a constructor if present, and `this()` must also be the first statement if present.",
        userAnswer: "`this()` must be the first statement in a constructor, and `super()` can be anywhere.",
        userIsCorrect: false
      }, {
        question: "What happens if a class has only private constructors?",
        correctAnswer: "Objects can only be created from within the class itself.",
        userAnswer: "Objects can only be created from within the class itself.",
        userIsCorrect: true
      }, {
        question: "Consider the following code: \n```java\nclass Parent {\n    Parent() {\n        System.out.println(\"Parent Constructor\");\n    }\n}\nclass Child extends Parent {\n    Child() {\n        System.out.println(\"Child Constructor\");\n    }\n}\npublic class Main {\n    public static void main(String[] args) {\n        new Child();\n    }\n}\n```\nWhat will be the output?",
        correctAnswer: "Parent Constructor\nChild Constructor",
        userAnswer: "Child Constructor",
        userIsCorrect: false
      }, {
        question: "Can a constructor throw an exception?",
        correctAnswer: "Yes, they can throw any type of exception.",
        userAnswer: "No, constructors are not allowed to throw exceptions.",
        userIsCorrect: false
      }, {
        question: "What is the significance of having a `private` constructor in a singleton design pattern?",
        correctAnswer: "It prevents direct instantiation of the class from outside, enforcing a single instance through a static method.",
        userAnswer: "It prevents direct instantiation of the class from outside, enforcing a single instance through a static method.",
        userIsCorrect: true
      }, {
        question: "Consider the following code: \n```java\nclass A {\n    A() {\n        System.out.println(\"A\");\n    }\n}\nclass B extends A {\n    B(int x) {\n        System.out.println(\"B \" + x);\n    }\n}\npublic class class Test {\n    public static void main(String[] args) {\n        new B(5);\n    }\n}\n```\nWhat is the output?",
        correctAnswer: "A\nB 5",
        userAnswer: "A\nB 5",
        userIsCorrect: true
      }, {
        question: "When is a copy constructor useful in Java?",
        correctAnswer: "To create a new object by copying the state of an existing object.",
        userAnswer: "To make a deep copy of an object, including all referenced objects.",
        userIsCorrect: false
      }, {
        question: "Can a constructor be `final`?",
        correctAnswer: "No, constructors cannot be final.",
        userAnswer: "No, constructors cannot be final.",
        userIsCorrect: true
      }, {
      question: "What is constructor chaining in Java?",
        correctAnswer: "The process of one constructor calling another constructor in the same class or a superclass.",
        userAnswer: "The process of one constructor calling another constructor in the same class or a superclass.",
        userIsCorrect: true
      }, {
        question: "Consider the following code: \n```java\nclass Base {\n    Base(String s) {\n        System.out.println(\"Base \" + s);\n    }\n}\nclass Derived extends Base {\n    Derived() {\n        // Line 1\n        System.out.println(\"Derived\");\n    }\n}\n```\nWhat should be placed at `// Line 1` to make the code compile and run successfully?",
        correctAnswer: "`super(\"World\");`",
        userAnswer: "Nothing, it compiles as is.",
        userIsCorrect: false
      }, {
        question: "What is the primary difference between a constructor and a method in Java?",
        correctAnswer: "Constructors initialize objects and have no return type; methods perform actions and have a return type.",
        userAnswer: "Constructors initialize objects and have no return type; methods perform actions and have a return type.",
        userIsCorrect: true
      }, {
        question: "Can a constructor be synchronized?",
        correctAnswer: "No, constructors cannot be synchronized.",
        userAnswer: "No, constructors cannot be synchronized.",
        userIsCorrect: true
      }, {
        question: "Consider the following code: \n```java\nclass MyClass {\n    String name;\n    int id;\n    MyClass(String name) {\n        this.name = name;\n    }\n    MyClass(String name, int id) {\n        this(name);\n        this.id = id;\n    }\n}\n```\nWhich type of constructor chaining is demonstrated here?",
        correctAnswer: "Chaining to another constructor in the same class (using `this()`)",
        userAnswer: "Chaining to another constructor in the same class (using `this()`)",
        userIsCorrect: true
      }, {
        question: "What is the purpose of the `super()` call in a constructor?",
        correctAnswer: "To invoke the constructor of the immediate superclass.",
        userAnswer: "To invoke the constructor of the immediate superclass.",
        userIsCorrect: true
      }, {
        question: "If a superclass has multiple constructors, how does a subclass constructor decide which one to call?",
        correctAnswer: "It must explicitly call one using `super()` with matching arguments.",
        userAnswer: "It must explicitly call one using `super()` with matching arguments.",
        userIsCorrect: true
      }, {
        question: "Consider the following code: \n```java\nclass Foo {\n    int value;\n    Foo(int value) {\n        this.value = value;\n    }\n}\nclass Bar extends Foo {\n    Bar() {\n        // Line A\n    }\n}\n```\nIf `Bar` is instantiated as `new Bar();`, what is the problem with `// Line A` if no change is made?",
        correctAnswer: "It will not compile because `Foo` does not have a no-argument constructor implicitly called by `Bar()`.",
        userAnswer: "It will not compile because `Foo` does not have a no-argument constructor implicitly called by `Bar()`.",
        userIsCorrect: true
      }, {
        question: "When a constructor uses `this()` to call another constructor, what is the order of execution?",
        correctAnswer: "The `this()` call executes first, then the remaining code in the calling constructor.",
        userAnswer: "The `this()` call executes first, then the remaining code in the calling constructor.",
        userIsCorrect: true
      }, {
        question: "Can a constructor contain a `return` statement?",
        correctAnswer: "Yes, but it must be `return;` (without a value).",
        userAnswer: "No, constructors cannot have return statements.",
        userIsCorrect: false
      }, {
        question: "Which scenario is a good use case for a `protected` constructor?",
        correctAnswer: "To allow only subclasses (in any package) and classes in the same package to create objects.",
        userAnswer: "To allow only subclasses (in any package) and classes in the same package to create objects.",
        userIsCorrect: true
      }, {
        question: "Consider the following code: \n```java\nclass Animal {\n    Animal(String type) {\n        System.out.println(\"Animal type: \" + type);\n    }\n}\nclass Dog extends Animal {\n    Dog() {\n        super(\"Canine\");\n        System.out.println(\"Woof!\");\n    }\n    Dog(String name) {\n        this(); // Line X\n        System.out.println(\"My dog's name is \" + name);\n    }\n}\npublic class Farm {\n    public static void main(String[] args) {\n        new Dog(\"Buddy\");\n    }\n}\n```\nWhat will be the output?",
        correctAnswer: "Animal type: Canine\nWoof!\nMy dog's name is Buddy",
        userAnswer: "Animal type: Canine\nMy dog's name is Buddy",
        userIsCorrect: false
      }, {
        question: "What is the consequence of not explicitly calling `super()` in a subclass constructor when the superclass has only parameterized constructors?",
        correctAnswer: "A compilation error occurs because the compiler cannot find a default no-argument superclass constructor.",
        userAnswer: "A compilation error occurs because the compiler cannot find a default no-argument superclass constructor.",
        userIsCorrect: true
      }, {
        question: "Consider the class `Singleton` with a `private` constructor. How can an instance of `Singleton` be obtained?",
        correctAnswer: "Through a `public static` factory method within the `Singleton` class itself.",
        userAnswer: "Through a `public static` factory method within the `Singleton` class itself.",
        userIsCorrect: true
      }, {
        question: "Which of the following is NOT a valid access modifier for a constructor?",
        correctAnswer: "`static`",
        userAnswer: "`static`",
        userIsCorrect: true
      }, {
        question: "Consider the following code: \n```java\nclass Shape {\n    Shape() {\n        System.out.println(\"Shape created\");\n    }\n}\nclass Circle extends Shape {\n    Circle(int radius) {\n        System.out.println(\"Circle with radius: \" + radius);\n    }\n}\npublic class Drawing {\n    public static void main(String[] args) {\n        new Circle(10);\n    }\n}\n```\nWhat is the output?",
        correctAnswer: "Shape created\nCircle with radius: 10",
        userAnswer: "Shape created\nCircle with radius: 10",
        userIsCorrect: true
      }, {
        question: "What is the main advantage of using constructor overloading?",
        correctAnswer: "It provides multiple ways to initialize an object, catering to different instantiation needs.",
        userAnswer: "It provides multiple ways to initialize an object, catering to different instantiation needs.",
        userIsCorrect: true
      }, {
        question: "Consider a class `Vehicle` with a constructor `Vehicle(String make, String model)`. If a subclass `Car` needs to initialize `make` and `model` through its constructor, what must its constructor do?",
        correctAnswer: "Call `super(make, model);` as the first statement.",
        userAnswer: "Call `super(make, model);` as the first statement.",
        userIsCorrect: true
      }, {
        question: "What is the primary reason a constructor cannot be overridden in Java?",
        correctAnswer: "Because overriding applies to methods with identical signatures in a subclass, and constructors are not methods.",
        userAnswer: "Because it would lead to ambiguity in object creation.",
        userIsCorrect: false
      }, {
        question: "Consider the output of the following Java code: \n```java\nclass Base {\n    Base() {\n        System.out.println(\"Base no-arg\");\n    }\n    Base(int x) {\n        System.out.println(\"Base int-arg: \" + x);\n    }\n}\nclass Derived extends Base {\n    Derived() {\n        this(5);\n        System.out.println(\"Derived no-arg\");\n    }\n    Derived(int y) {\n        super(y);\n        System.out.println(\"Derived int-arg: \" + y);\n    }\n}\npublic class Main {\n    public static void main(String[] args) {\n        new Derived();\n    }\n}\n```\nWhat is the output when `new Derived()` is executed?",
        correctAnswer: "Base int-arg: 5\nDerived int-arg: 5\nDerived no-arg",
        userAnswer: "Base int-arg: 5\nDerived int-arg: 5\nDerived no-arg",
        userIsCorrect: true
      }, {
        question: "When does the compiler NOT provide a default constructor for a class?",
        correctAnswer: "When any other constructor (parameterized or no-argument) is explicitly defined in the class.",
        userAnswer: "When any other constructor (parameterized or no-argument) is explicitly defined in the class.",
        userIsCorrect: true
      }
    ]
  };

  useEffect(() => {
    const initializeFirebase = async () => {
      try {
        const app = initializeApp(firebaseConfig);
        const authInstance = getAuth(app);
        const firestoreInstance = getFirestore(app);

        setAuth(authInstance);
        setDb(firestoreInstance);

        // Sign in anonymously or with custom token
        if (initialAuthToken) {
          await signInWithCustomToken(authInstance, initialAuthToken);
        } else {
          await signInAnonymously(authInstance);
        }

        onAuthStateChanged(authInstance, (user) => {
          if (user) {
            setUserId(user.uid);
            setLoading(false);
          } else {
            setUserId(null);
            setLoading(false);
          }
        });
      } catch (error) {
        console.error("Error initializing Firebase:", error);
        setMessage(`Error initializing Firebase: ${error.message}`);
        setLoading(false);
      }
    };

    initializeFirebase();
  }, []);

  useEffect(() => {
    if (db && userId) {
      const quizzesCollectionRef = collection(db, `artifacts/${appId}/users/${userId}/quizzes`);
      const q = query(quizzesCollectionRef, orderBy('timestamp', 'desc'));

      const unsubscribe = onSnapshot(q, (snapshot) => {
        const fetchedQuizzes = snapshot.docs.map(doc => ({
          id: doc.id,
          ...doc.data()
        }));
        setQuizzes(fetchedQuizzes);
      }, (error) => {
        console.error("Error fetching quizzes:", error);
        setMessage(`Error fetching quizzes: ${error.message}`);
      });

      return () => unsubscribe(); // Cleanup listener on unmount
    }
  }, [db, userId]);

  const addQuizToHistory = async () => {
    if (!db || !userId) {
      setMessage("Firebase not initialized or user not authenticated.");
      return;
    }

    try {
      const quizzesCollectionRef = collection(db, `artifacts/${appId}/users/${userId}/quizzes`);
      await addDoc(quizzesCollectionRef, {
        ...lastQuizResult, // Use the hardcoded last quiz result
        timestamp: serverTimestamp(),
      });
      setMessage("Quiz result added successfully!");
    } catch (error) {
      console.error("Error adding quiz result:", error);
      setMessage(`Error adding quiz result: ${error.message}`);
    }
  };

  if (loading) {
    return (
      <div className="flex items-center justify-center min-h-screen bg-gray-100 p-4 font-sans">
        <p className="text-lg text-gray-700">Loading application...</p>
      </div>
    );
  }

  return (
    <div className="min-h-screen bg-gray-100 flex flex-col items-center p-4 sm:p-6 lg:p-8 font-sans">
      <div className="bg-white p-6 sm:p-8 rounded-xl shadow-lg w-full max-w-2xl">
        <h1 className="text-3xl font-bold text-gray-800 mb-6 text-center">Quiz History Tracker</h1>

        {userId && (
          <p className="text-sm text-gray-600 mb-4 text-center">
            Your User ID: <span className="font-mono bg-gray-200 px-2 py-1 rounded">{userId}</span>
          </p>
        )}

        <div className="mb-6 text-center">
          <button
            onClick={addQuizToHistory}
            className="bg-blue-600 hover:bg-blue-700 text-white font-semibold py-3 px-6 rounded-lg shadow-md transition duration-300 ease-in-out transform hover:scale-105 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-opacity-75"
          >
            Add Last Quiz Result to History
          </button>
          {message && (
            <p className="mt-4 text-sm text-center text-red-600">{message}</p>
          )}
        </div>

        <h2 className="text-2xl font-semibold text-gray-700 mb-4 border-b pb-2">Your Quiz History</h2>

        {quizzes.length === 0 ? (
          <p className="text-gray-600 text-center">No quizzes recorded yet. Add your first quiz!</p>
        ) : (
          <ul className="space-y-4">
            {quizzes.map((quiz) => (
              <li key={quiz.id} className="bg-gray-50 p-4 rounded-lg shadow-sm border border-gray-200">
                <p className="text-lg font-medium text-gray-800">{quiz.quizTitle}</p>
                <p className="text-md text-gray-700">Score: <span className="font-semibold">{quiz.score}</span></p>
                <p className="text-sm text-gray-500">
                  Date: {quiz.timestamp ? new Date(quiz.timestamp.toDate()).toLocaleString() : 'Loading...'}
                </p>
                {/* You can expand this to show detailed answers if needed */}
              </li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
}

export default App;
