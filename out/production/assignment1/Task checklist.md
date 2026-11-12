# Task and subtask checklist

## Task 0 — Repository and preparation — Ray
- [ ] Confirm all three have repository access
- [ ] All three clone and successfully run the original code
- [ ] Agree on branch and pull-request conventions
- [ ] Create README.md and PLAN.md
- [ ] Agree on the initial architecture discussion and assignments

## Task 1 — Basic inheritance — Ray
- [ ] Compare Volvo240 and Saab95 fields, constructors and methods
- [ ] Identify shared and model-specific responsibilities
- [ ] Answer implementation vs specification inheritance questions
- [ ] Propose superclass/subclass structure
- [ ] Explain how the design improves the Open-Closed Principle
- [ ] Identify an extension possible without modifying existing code
- [ ] Identify an extension that would require modifying existing code
- [ ] Decide public, protected and private visibility
- [ ] Both reviewers confirm understanding of the proposal
- [ ] Implement the approved inheritance hierarchy
- [ ] Check that original functionality is preserved
- [ ] Both reviewers examine the code and confirm understanding

## Task 2 — Action interfaces — Rishav
- [ ] Explain the purpose of the Movable interface
- [ ] Define required move, turnLeft and turnRight operations
- [ ] Agree on position and direction representation
- [ ] Both reviewers confirm the proposed behavior
- [ ] Implement the interface and required movement behavior
- [ ] Check movement and turning with representative examples
- [ ] Both reviewers examine code and confirm understanding

## Task 3 — Testing — Abu
- [ ] Explain unit testing and expected versus actual results
- [ ] Identify tests for Task 1 functionality
- [ ] Identify tests for Task 2 movement and turning
- [ ] Both reviewers confirm test coverage and expected behavior
- [ ] Implement the test suite using the assignment's test style
- [ ] Run tests and investigate failures
- [ ] Both reviewers confirm test logic and results

## ## Task 4 — Sanity Check- All membrs

### Ray — Speed boundaries

- [ ] Verify that `currentSpeed` never becomes negative.
- [ ] Verify that `currentSpeed` never exceeds `enginePower`.
- [ ] Identify boundary cases that could violate these limits.
- [ ] Write tests for these conditions before implementing corrections.
- [ ] Implement the necessary speed-boundary checks.
- [ ] Review Member B's and Member C's work.
- [ ] Confirm understanding of the complete sanity-check implementation.

### Member B — Acceleration (`gas()`)

- [ ] Verify that `gas(amount)` accepts only values between `0` and `1`, inclusive.
- [ ] Verify that acceleration never decreases `currentSpeed`.
- [ ] Test normal, boundary, and invalid input values.
- [ ] Write failing tests before implementing corrections.
- [ ] Implement the required acceleration validation.
- [ ] Review Ray's and Member C's work.
- [ ] Confirm understanding of the complete sanity-check implementation.

### Member C — Braking (`brake()`)

- [ ] Verify that `brake(amount)` accepts only values between `0` and `1`, inclusive.
- [ ] Verify that braking never increases `currentSpeed`.
- [ ] Test normal, boundary, and invalid input values.
- [ ] Write failing tests before implementing corrections.
- [ ] Implement the required braking validation.
- [ ] Review Ray's and Member B's work.
- [ ] Confirm understanding of the complete sanity-check implementation.

### Shared review and integration

- [ ] Agree on how invalid inputs should be handled before implementation.
- [ ] Coordinate changes to shared methods and files to avoid Git conflicts.
- [ ] Confirm that all three implementations work together.
- [ ] Run the complete test suite.
- [ ] Verify that corrections do not break existing functionality.
- [ ] Both other members review each person's contribution.
- [ ] All three members confirm they understand the complete solution.
- [ ] Merge approved changes into `main`.
- [ ] Update documentation.

### Definition of Done

Task 4 is complete when:

- [ ] All sanity-check requirements are satisfied.
- [ ] All relevant tests pass.
- [ ] The code has been reviewed by all three members.
- [ ] The final implementation is integrated into the repository.
- [ ] Every member can explain the validation logic, speed limits, and expected behavior.

## Final — Integration and demonstration — All members 
- [ ] All pull requests merged and conflicts resolved
- [ ] Compile and run the full project
- [ ] Run complete test suite
- [ ] Review design explanations and reflection questions
- [ ] Update README with final architecture and contributions
- [ ] Conduct oral rehearsal: each member explains unfamiliar code
- [ ] Verify submission URL and repository access
- [ ] Submit and prepare for TA demonstration
