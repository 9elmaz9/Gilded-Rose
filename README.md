# Gilded Rose Refactoring Kata - Version 2.0

## Introduction

Hey everyone! 👋 Welcome to version 2.0 of my **Gilded Rose Refactoring** project. In this version, I’ve implemented significant changes based on the feedback I received from experienced developers. The goal was to make the code more modular, maintainable, and scalable while improving readability and test coverage.

The code now adheres more closely to **SOLID** principles, allowing for easier extension and improvement of the system. Additionally, I’ve significantly expanded the test suite to ensure stability across different scenarios.

## What's New? 🛠️

This version introduces a range of improvements and refactorings that enhance the overall quality and flexibility of the code.

### 1. **Improved Structure and Separation of Concerns**

Previously, all item types were handled by a single function, which made the code difficult to maintain and extend. In version 2.0, I separated the logic into individual classes, each responsible for handling specific item behavior:

- `AgedBrieItemQualityModifier`: Handles the logic for the "Aged Brie" item.
- `BackstageItemQualityModifier`: Manages the behavior for "Backstage passes to a TAFKAL80ETC concert".
- `DefaultItemQualityModifier`: Deals with regular items.
- `SulfurasItemQualityModifier`: Manages the legendary "Sulfuras, Hand of Ragnaros".

This approach makes the code more modular and readable, improving scalability for future modifications.

### 2. **Introducing Interfaces for Common Behavior**

To reduce code duplication and ensure consistency, I introduced the `ItemQualityModifier` interface. Each item type now implements this interface, ensuring that shared logic, such as updating quality and sell-in values, is handled consistently across item types.

This refactor also makes it easier to introduce new item types in the future, as all items now follow a consistent pattern. The interface provides flexibility, allowing each item to customize its own behavior while adhering to common rules.

### 3. **Factory Design Pattern**

I implemented an `ItemQualityModifierFactory` that is responsible for determining which `ItemQualityModifier` to use for each item. This centralizes the decision-making process, making it easier to add new item types in the future without modifying the core logic.

### 4. **Helper Class**

I created a helper class called `ItemQualityHelper` to handle common conditions, such as ensuring quality stays within valid bounds or checking if the sell-in date has passed. This reduces code duplication and keeps the core logic focused.

## Key Changes from Version 1.0 📝

In version 1.0, all logic for updating item quality and sell-in values was crammed into a single function, making it hard to understand and maintain. The refactoring in version 2.0 addressed these issues by:

- **Encapsulating behavior**: Logic for different item types is now handled by separate classes, making the code more organized and easier to extend.
- **Centralizing common logic**: The use of an interface and helper class reduces code duplication, ensuring that common logic is reused across different item types.
- **Improving testability**: With isolated classes for each item type, it’s now easier to write unit tests that verify the behavior of individual items.

## Class Breakdown 💡

Here’s a closer look at the key classes and their responsibilities:

### `AgedBrieItemQualityModifier`
Handles the behavior for "Aged Brie", where quality increases as the item ages. The sell-in value decreases by 1 each day, and quality increases by 1 until it reaches a maximum of 50.

### `BackstageItemQualityModifier`
Manages "Backstage passes to a TAFKAL80ETC concert". The quality increases as the sell-in date approaches:
- 10 days or less: Quality increases by 2.
- 5 days or less: Quality increases by 3.
- After the concert: Quality drops to 0.

### `DefaultItemQualityModifier`
Handles standard items, where quality decreases as the sell-in date approaches. Before the sell-in date, quality decreases by 1. After the sell-in date, quality decreases by 2. The quality never falls below 0.

### `SulfurasItemQualityModifier`
Handles "Sulfuras, Hand of Ragnaros", a legendary item that never needs to be sold and maintains a constant quality of 80.

### `ItemQualityModifierFactory`
This factory class determines which `ItemQualityModifier` should be used for each item, based on the item's name. This ensures the logic remains flexible and easy to extend when new item types are introduced.

### `ItemQualityHelper`
A utility class that provides helper methods to check common conditions, such as whether the quality is within valid bounds or if the sell-in date has passed.

## Testing Improvements 🧪

A significant focus in version 2.0 was enhancing the test suite to cover all possible scenarios. I expanded the tests to include edge cases and parameterized testing, ensuring robust validation of all item behaviors.

### What the Tests Cover:

- **Aged Brie**: 
  - Ensures quality increases as the item ages.
  - Verifies behavior when the sell-in date has passed.
  - Confirms that quality never exceeds 50.
  
- **Backstage Passes**:
  - Validates that quality increases correctly as the concert approaches.
  - Ensures quality drops to 0 after the concert.
  
- **Sulfuras**:
  - Ensures the quality remains constant at 80.
  - Ensures the sell-in value does not change.
  
- **Default Items**:
  - Ensures quality decreases by 1 before the sell-in date.
  - Ensures quality decreases by 2 after the sell-in date.
  - Confirms that quality never drops below 0.

### Parameterized Testing:

To ensure robustness, I used parameterized tests for scenarios that apply to multiple inputs, such as testing items with various qualities and sell-in values. This reduces redundancy and keeps the test suite maintainable.


## How to Run the Tests 🏃‍♂️

To run the tests, simply execute the following commands in your terminal:

  ```bash
./gradlew test
 ```

You’ll see detailed results for each test case, ensuring that every type of item in the system behaves as expected.

## Conclusion:

In version 2.0, I’ve taken significant steps to refactor the code and make the system more modular, scalable, and testable. This update resolves a lot of the issues from the previous version and sets up the project for easier future maintenance.

I’m really proud of this update—it was challenging but incredibly rewarding to see how much cleaner and more efficient the code is now! I look forward to exploring new ideas and considering additional improvements to make the system even more robust and efficient in the future! 😊 Feel free to explore the code and reach out if you have any questions or suggestions.



