# Gilded Rose Refactoring Kata - Version 2.0 🎉

## Introduction

Hey everyone! 👋 Welcome to my **Gilded Rose** refactoring project. This is **version 2.0** of the project, where I have implemented some major improvements and refactoring based on feedback I received. The goal was to make the code cleaner, more modular, and much easier to maintain. I’ve also significantly expanded the test suite to ensure everything runs smoothly!

## What’s New? 🛠️

In this version, I’ve focused on refactoring the code to adhere to **SOLID principles**. The original project had logic for all item types mixed into one function, which made it difficult to extend and maintain. I knew that separating the concerns of each item type and implementing cleaner class structures would make the project more scalable and adaptable to future changes.

### Here's a breakdown of the changes I've made:

1. **Better Structure and Separation of Concerns**:  
   I broke down the logic into different classes where each class now handles a specific type of item behavior. For example:
   - `AgedBrieItemQualityModifier` for "Aged Brie"
   - `BackstageItemQualityModifier` for "Backstage passes to a TAFKAL80ETC concert"
   - `DefaultItemQualityModifier` for standard items
   - `SulfurasItemQualityModifier` for the legendary "Sulfuras, Hand of Ragnaros"
   
   This made the code more modular and easier to read and understand.

2. **Abstract Class for Common Behavior**:  
   I introduced an **abstract class** for handling common behavior across item types, allowing the logic that applies to all items (e.g., decreasing the sell-in value or checking quality constraints) to be centralized. This drastically reduces the duplication of code and ensures that the logic for different item types only contains what is specific to that item. This change also makes it much easier to introduce new item types since you can simply extend the abstract class and override only what’s necessary.
   
   This approach ensures that each item type follows a consistent pattern, but still allows for flexibility and customization where needed.

3. **Following SOLID Principles**:  
   By implementing SOLID principles, I ensured that:
   - Each class has a **single responsibility** (SRP),
   - The system is **open for extension** but **closed for modification** (OCP),
   - Classes can be substituted without altering the program's correctness (**Liskov Substitution**),
   - Classes are small and focused, using interfaces that are only relevant to the class (**Interface Segregation**),
   - Dependencies are inverted, meaning the system relies on abstractions rather than concrete classes (**Dependency Inversion**).

4. **Factory Design Pattern**:  
   I introduced an `ItemQualityModifierFactory` that is responsible for determining which `ItemQualityModifier` to use for each item. This centralized the decision-making and made adding new item types much easier in the future.

5. **Helper Class**:  
   I created a helper class called `ItemQualityHelper` to handle common conditions such as checking whether the quality is within valid bounds or whether the sell-in date has passed. This keeps the main logic focused and reduces code duplication.

## Key Changes from the Previous Version 📝

In **version 1.0**, the entire logic for updating item quality and sell-in was cramped into one function. It was difficult to understand and even harder to maintain. By splitting the code into separate classes and abstracting common behavior, I’ve made it easier to follow and much more efficient.

For example, in the previous version:
- Handling each item type required adding more and more `if-else` conditions, which would quickly become unmanageable.
- Testing was challenging because everything was interconnected.

In **version 2.0**, the refactoring has resolved these issues by:
- Making the code more extensible by removing the monolithic logic and replacing it with class-specific behavior.
- Centralizing common logic into an abstract class, reducing code duplication and simplifying future extensions.
- Enabling better testability with isolated tests for each item type.

## Classes Breakdown 💡

### `AgedBrieItemQualityModifier`

Handles the logic for "Aged Brie", where the quality improves as it ages. The sell-in value decreases by 1 each day, and the quality increases until it reaches a cap of 50.

### `BackstageItemQualityModifier`

Handles "Backstage passes to a TAFKAL80ETC concert", where the quality increases as the sell-in date approaches:
- 10 days or less: Quality increases by 2.
- 5 days or less: Quality increases by 3.
- After the concert: Quality drops to 0.

### `DefaultItemQualityModifier`

Handles generic items where the quality decreases as the sell-in date approaches. The quality decreases by 1 each day, and after the sell-in date, it decreases by 2. The quality never goes below 0.

### `SulfurasItemQualityModifier`

Handles "Sulfuras, Hand of Ragnaros", a legendary item that never decreases in quality and does not need to be sold. It stays at a constant quality of 80.

### `ItemQualityModifierFactory`

This class decides which modifier should be used based on the item’s name. This makes the logic extensible and easy to update whenever new item types are introduced.

### `ItemQualityHelper`

This helper class provides utility functions to handle quality and sell-in logic across all item types, such as:
- Checking if the sell-in date has passed,
- Ensuring that quality remains within valid bounds.

## Testing Improvements 🧪

One of the biggest changes in this version is the enhanced test suite. I wanted to make sure every aspect of the item behavior was well covered, so I added a variety of test cases.

### What the Tests Cover:

- **Aged Brie**:
  - Ensures that the quality increases as the item ages.
  - Tests the behavior when the sell-in date has passed.
  - Ensures that quality never exceeds 50.

- **Backstage Passes**:
  - Validates that quality increases correctly as the concert approaches.
  - Ensures quality drops to 0 after the concert.

- **Sulfuras**:
  - Ensures the quality remains constant at 80.
  - Ensures the sell-in value does not change.

- **Default Items**:
  - Ensures quality decreases by 1 before the sell-in date.
  - Ensures quality decreases by 2 after the sell-in date.
  - Ensures quality never goes below 0.

- **Edge Cases**:
  - Items with negative sell-in values.
  - Items with maximum quality.

### Parameterized Testing:

To ensure robustness, I used **parameterized tests** for scenarios that apply to multiple inputs, such as testing items with various qualities and sell-in values. This reduces redundancy and makes the test suite more maintainable.

## Abstract Class and its Benefits 🌟

The introduction of an abstract class to centralize common behavior was a crucial improvement in this refactor. By moving logic that applies to all items (such as reducing the `sellIn` value or capping the `quality` at 50) into an abstract class, I was able to:
- **Reduce duplication**: The common logic is now defined once in the abstract class instead of being repeated in every class.
- **Improve scalability**: When adding new item types, I no longer need to worry about implementing basic behavior from scratch. Instead, I can just inherit from the abstract class and override the specific behavior unique to that item type.
- **Maintain consistency**: Since the basic item logic is centralized, every item type now follows the same structure, reducing the chances of accidental inconsistencies or bugs.

This approach also helps to ensure that all item types are treated fairly in terms of logic, while still allowing for flexibility when necessary.

## How to Run the Tests 🏃‍♂️

To run the tests, simply execute the following commands in your terminal:

```bash
./gradlew test


You’ll see detailed results for each test case, ensuring that every type of item in the system behaves as expected.

### Conclusion:

In version 2.0, I’ve taken significant steps to refactor the code and make the system more modular, scalable, and testable. This update resolves a lot of the issues from the previous version and sets up the project for easier future maintenance.

I’m really proud of this update—it was challenging but incredibly rewarding to see how much cleaner and more efficient the code is now! 😊 Feel free to explore the code, run the tests, and reach out if you have any feedback!


