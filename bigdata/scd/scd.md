# SCD (Slowly changed dimensions)

## Types

### Type-0 : The starting point

Type 0 dimension is the starting point. No changes are applied to the existing attributes of the dimension; only new records are added, so no history is stored or tracked in such a case for one attribute, e.g., DateOfBirth.

Key features:

* Type 0 applies to most date dimension attributes.
The dimension attribute value never changes, so facts in the fact table are always grouped by this original value, and the attribute does not have a history, for example, names of countries and continents.
* Natural keys are used in type 0 dimensions.
* You can add new rows while keeping existing rows unchanged.

### Type-1 : Overwrite old value (like a temporary or staging table)

|Cust|Name            |Type|
|----|----------------|----|
|1   |Sun Microsystems|It

|Cust|Name              |Type|
|----|------------------|----|
|1   |Oracle Corporation|It

### Type-2 : Create new additional record

|Cust|Name  |Type|Start Date|End Date|Is current|
|----|------|----|----------|--------|----------|
|1   |Sun   |It  |01-01-1980|null    |Y


|Cust|Name  |Type|Start Date|End Date  |Is current|
|----|------|----|----------|----------|----------|
|1   |Sun   |It  |01-01-1980|01-01-2000|N
|2   |Oracle|It  |01-01-2000|null      |Y

### Type-3 : Add new column

### Type-4 : Use a historical table

Combination of 1 and 2

Current Table

|Surrogate Key|Cust Id|Name              |Type|
|-------------|-------|------------------|----|
|1            |1      |Oracle Corporation|It

Historical table
