package org.example;
import java.sql.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void CREATE_TABLE(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        String tableName = clazz.getSimpleName().toLowerCase();
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (");

        Map<Class<?>, String> columnTypeMap = createColumnTypeMap();
        for (Field field : fields) {
            field.setAccessible(true);

            if (!field.isAnnotationPresent(Column.class)) { // Пропускаем поля без аннотации @Column
                continue;
            }

            Class<?> fieldType = field.getType();
            String columnName = field.getName();
            String columnType = columnTypeMap.get(fieldType);
            queryBuilder.append(columnName).append(" ").append(columnType).append(", ");
        }
        queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length());
        queryBuilder.append(");");
        String createTableQuery = queryBuilder.toString();
        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<Class<?>, String> createColumnTypeMap() {
        Map<Class<?>, String> columnTypeMap = new HashMap<>();
        columnTypeMap.put(String.class, "VARCHAR");
        columnTypeMap.put(int.class, "INT");
        columnTypeMap.put(double.class, "DOUBLE");
        columnTypeMap.put(boolean.class, "BOOLEAN");
        columnTypeMap.put(Color.class, "VARCHAR");
        return columnTypeMap;
    }

    public static void DELETE_TABLE(Class<?> clazz) {
        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            String tableName = tableAnnotation.Title();
            String deleteTableQuery = "DELETE FROM " + tableName;
        try {
            statement.executeUpdate(deleteTableQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }}
    }

    public static void DROP_TABLE(Class<?> clazz) {
        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            String tableName = tableAnnotation.Title();
        String dropTableQuery = "DROP TABLE IF EXISTS " + tableName;
        try {
            statement.executeUpdate(dropTableQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }}
    }
    public static void insertToTable(Object object) {
        Class<?> clazz = object.getClass();
        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            String tableName = tableAnnotation.Title();
            Field[] fields = clazz.getDeclaredFields();
            StringBuilder query = new StringBuilder("INSERT OR IGNORE INTO " + tableName + " (");
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    query.append(field.getName()).append(",");
                }
            }
            query.deleteCharAt(query.length() - 1).append(") VALUES (");
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    try {
                        query.append("'").append(field.get(object)).append("',");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            query.deleteCharAt(query.length() - 1).append(")");
            String insertToTable = query.toString();
            try {
                statement.execute(insertToTable);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        connect();
        //CREATE_TABLE(Losos.class);
        Losos losos = new Losos("Пескарь Иванович", 13.1, Color.white);
        Losos losos1 = new Losos("Оптимус Прайм", 100, Color.blue);
        Losos losos2 = new Losos("Андрей Мореходооов", 777.6, Color.black);

        Losos[] lososArray = {losos, losos1, losos2};
        //DELETE_TABLE(Losos.class);
        boolean dropTable = false;
        for (Losos l : lososArray) {
            if (!dropTable) {
                DROP_TABLE(l.getClass());
                dropTable = true;
            }
            CREATE_TABLE(l.getClass());
            insertToTable(l);
        }
        disconnect();
    }
    public static void connect(){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:LR9.db");
            statement = connection.createStatement();
        }
        catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
    }
    public static void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}