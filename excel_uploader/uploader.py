import pandas as pd
from sqlalchemy import create_engine
import psycopg2                            #твой логин:пароль             имя бд
engine=create_engine("postgresql+psycopg2://postgres:0000@localhost:5432/db") #здесь указываешь свои данные от postgres

excel_file_name_list = ['1.xlsx', '2.xlsx', '3.xlsx', '4.xlsx']

sheets_for_1 = ["1.1н", "1.2н", "1.3н", "2.1н", "2.2н", "2.3н", "3.1н", "3.2н", "3.3н", "4.1н", "4.2н", "4.3н"]

sheets_for_2 = ["5.1н", "5.2н", "5.3н", "6.1н", "6.2н", "6.3н", "7.1н", "7.2н", "7.3н", "8.1н", "8.2н", "8.3н"]

sheets_for_3 = ["9.1 Н", "9.2 Н", "9.3 Н", "10.1 Н", "10.2 Н", "10.3 Н", "11.1 Н", "11.2 Н", "11.3 Н", "12.1 Н", "12.2 Н", "12.3 Н"]

sheets_for_4 = ["13.1н", "13.2н", "13.3н", "14.1н", "14.2н", "14.3н", "15.1н", "15.2н", "15.3н", "16.1н", "16.2н", "16.3н"]

for excel_file_name in excel_file_name_list:
    with pd.ExcelFile(excel_file_name) as xls:
        if excel_file_name == '1.xlsx':
            for sheet in sheets_for_1:
                df = pd.read_excel(xls, sheet)
                df.to_sql(name='region_criteria', con=engine, if_exists='append', index=False)
        elif excel_file_name == '2.xlsx':
            for sheet in sheets_for_2:
                df = pd.read_excel(xls, sheet)
                df.to_sql(name='region_criteria', con=engine, if_exists='append', index=False)
        elif excel_file_name == '3.xlsx':
            for sheet in sheets_for_3:
                df = pd.read_excel(xls, sheet)
                df.to_sql(name='region_criteria', con=engine, if_exists='append', index=False)
        else:
            for sheet in sheets_for_4:
                df = pd.read_excel(xls, sheet)
                df.to_sql(name='region_criteria', con=engine, if_exists='append', index=False)

connection = create_connection("db", "postgres", "0000", "localhost", "5432")

sql_query = "Call refresh_all()"

data_base_refresh_query(connection, sql_query)

