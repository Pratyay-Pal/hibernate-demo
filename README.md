# hibernate-demo
Old hibernate code. Uploaded for code storage purposes. Most of it already deprecated. Does not follow best practices. Use at your own risk. 

#### How to use?
1. Run the SQL scripts present in src/main/resources/SQL/Schema against any database. This will create the table.
2. Run the SQL scripts present in src/main/resources/SQL/Data against any database. This will create the data for the tables.
3. Edit the DBConfig.java file present in src/main/java/com/pc/gpu/config. Update it with the database details as needed.
4. Run the application.
5. Profit

#### Endpoints?
- /gpu/company - Lists the companies configured in the table. GET Request
- /gpu/gpuname - Lists all GPU(s) made by the company obtained from the previous response. POST Request, send company.
- /gpu/gpudetails - Lists all the properties of the GPU obtained from the previous response. POST Request, send gpuname.
