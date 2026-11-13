# Assignment 1 — Task 1: Basic Inheritance

## Inheritance Hierarchy: Implementation Inheritance

Both `Saab95` and `Volvo240` can be subclasses since they share similar fields and methods, although they have some differences in their fields and constructors.

This is the reason why I chose to create a superclass, completing the design as follows:

**Superclass:** `Vehicle`  
**Subclasses:** `Volvo240` and `Saab95`

```text
       Vehicle
       /     \
  Volvo240   Saab95
```

---

## Q1. Should you use implementation inheritance (subclassing) or specification inheritance (interfaces)? Why?

Since both subclasses have similar structures and attributes, with differences mainly in their initial values and some model-specific behavior, implementation inheritance is the most suitable design for this case.

This eliminates duplicated implementations, reduces maintenance effort, and permits subclasses to specialize their behavior.

The disadvantage of using a superclass is that both subclasses become dependent on the superclass design, whereas interfaces can reduce dependency on particular implementations.

However, I see no significant problem with this dependency in our case, since both subclasses represent cars and share almost the same structure.

That is why specification inheritance (interfaces) is not necessary for Task 1.

---

## Q2. Can both be used? What advantages and disadvantages do you see?

Both can be used.

However, I still think implementation inheritance through a superclass is more suitable for Task 1, since the main goal is to eliminate duplication.

Interfaces help reduce dependencies on particular implementations and define common behavior, but they do not automatically eliminate duplicated implementations.

Since both car classes share identical logic in several methods, using only an interface would not solve our main problem.

---

## Q3. How does your solution follow the Open-Closed Principle better than the original code? Think of an extension that is now possible without modifying existing code.

Our superclass design follows the Open-Closed Principle (OCP) because it allows us to introduce new car models by extending the shared structure from the superclass.

This allows us to reuse existing functionality and include new model-specific features or behavior without modifying the existing car models.

For example, we could introduce a new car model as a subclass of `Vehicle`, inheriting the common fields and methods while implementing its own `speedFactor()` calculation.

---

## Q4. Can you think of any extensions that would require changing existing code?

An extension that could require modifying existing code is introducing new functionality that must apply to every car model.

For example, suppose every vehicle must record how many times its engine has been started.

Our current superclass `Vehicle` contains the shared `startEngine()` method, but it does not track the number of engine starts.

To implement this requirement through our existing design, we would need to modify `Vehicle` by introducing a new field to count the engine starts and updating `startEngine()` to increase that counter.

This demonstrates a limitation of our inheritance hierarchy.

The Open-Closed Principle does not mean that existing code must never be modified. It means we should design our classes so that anticipated extensions can be implemented without changing existing functionality.

In our case, adding a new car model can be achieved through inheritance. However, changing the functionality shared by all vehicles may require modifying the superclass.

