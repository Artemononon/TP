package org.example;

import java.sql.*;

public class Main {
    static Connection connection;
    static Statement statement;
    public static void main(String[] args) throws SQLException {
        connect();

        statement.execute("drop table if exists результат;");
        statement.execute("drop table if exists студенты;");
        statement.execute("drop table if exists предметы;");
        statement.execute("CREATE TABLE IF NOT EXISTS студенты" +
                "(id serial not null PRIMARY KEY," +
                " имя varchar(30) not null," +
                " СерияПаспорта varchar(4) not null," +
                " НомерПаспорта varchar(6) not null," +
                " UNIQUE (СерияПаспорта, НомерПаспорта)" +
                ");");
        statement.execute("CREATE TABLE IF NOT EXISTS предметы" +
                "(id serial not null PRIMARY KEY, название varchar(50) not null);");

        statement.execute("CREATE TABLE IF NOT EXISTS результат" +
                "(id serial not null PRIMARY KEY," +
                " студент int not null REFERENCES студенты(id) ON DELETE CASCADE," +
                " предмет int not null REFERENCES предметы(id)," +
                " оценка smallint CHECK(оценка BETWEEN 2 and 5));");
        statement.execute("INSERT into студенты (id, имя, СерияПаспорта, НомерПаспорта) values" +
                "    (1, 'Артем', 1111, 111111)," +
                "    (2, 'Андрей', 2222, 222222)," +
                "    (3, 'Роман', 3333, 333333)," +
                "    (4, 'Борода', 4444, 444444)," +
                "    (5, 'Данил', 5555, 555555)," +
                "    (6, 'Леха', 6666, 666666);");

        statement.execute("INSERT into предметы (id, название) values" +
                "    (1, 'Математика')," +
                "    (2, 'Русский язык')," +
                "    (3, 'Литература')," +
                "    (4, 'Физкультура')," +
                "    (5, 'ИЗО')," +
                "    (6, 'Информатика');");
        statement.execute("INSERT into результат (id, студент, предмет, оценка) values" +
                "    (1, 1, 1, null)," +
                "    (2, 2, 2, 4)," +
                "    (3, 3, 2, 5)," +
                "    (4, 4, 3, 2)," +
                "    (5, 1, 3, 2)," +
                "    (6, 6, 6, 2);");

        System.out.println("Вывести список студентов, сдавших определенный предмет, на оценку выше 3");
        var z1 = statement.executeQuery("Select с.имя, р.оценка, п.название from студенты с " +
                "join результат р on с.id = р.студент " +
                "join предметы п on п.id = р.предмет " +
                "WHERE р.оценка > 3 and п.название = 'Русский язык';");
        while (z1.next()) {
            String subjName = z1.getString(1);
            int mark = z1.getInt(2);
            String studName = z1.getString(3);
            System.out.println(subjName + " " + mark + " " + studName);
        }

        System.out.println("Посчитать средний балл по определенному предмету");
        var z2 = statement.executeQuery("select avg(р.оценка) from результат р " +
                "join предметы п on р.предмет = п.id " +
                "where п.название = 'Математика';");
        while (z2.next()) {
            double avg = z2.getDouble(1);
            System.out.println(avg);
        }

        System.out.println("Посчитать средний балл по определенному студенту");
        var z3 = statement.executeQuery("select avg(р.оценка) from студенты с " +
                "join результат р on с.id = р.студент " +
                "where с.имя = 'Андрей';");
        while (z3.next()) {
            double avg = z3.getDouble(1);
            System.out.println(avg);
        }

        System.out.println("Найти три предмета, которые сдали наибольшее количество студентов");
        var z4 = statement.executeQuery("SELECT count(*), п.название from результат р " +
                "join предметы п on п.id = р.предмет " +
                "where р.оценка > 2 " +
                "group by п.название " +
                "order by count(*) desc limit 3;");
        while (z4.next()) {
            int cnt = z4.getInt(1);
            String name = z4.getString(2);
            System.out.println(cnt + " " + name);
        }

        System.out.println("Вывести список студентов, сдавших предмет, на оценку ниже 3 или не имеющих оценку");
        var z5 = statement.executeQuery("Select с.имя,  п.название from студенты с " +
                "join результат р on с.id = р.студент " +
                "join предметы п on п.id = р.предмет " +
                "WHERE р.оценка < 3 or р.оценка is null;");
        while (z5.next()) {
            String subjName = z5.getString(1);
            String studName = z5.getString(2);
            System.out.println(subjName + " " + studName);
        }
        System.out.println();
        disconnect();


    }
    public static void connect()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:LR10.db");
            statement = connection.createStatement();
        }
        catch (ClassNotFoundException| SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void disconnect()
    {
        try
        {
            statement.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        try
        {
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}