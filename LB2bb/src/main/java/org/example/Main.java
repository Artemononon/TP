package org.example;

public class Main {
    private static int SuperJump = 2;

    public static int getSuperJump() {
        return SuperJump;
    }

    public static void decrementSuperJumpCount() {
        SuperJump--;
    }

    public static void main(String[] args) {
        Member[] members = {
                new Cat("mr.Martin", 69, 1),
                new Cat("mr.Stepan", 70, 1),
                new Person("mr.Roman", 50, 1),
                new Robot("mr.Transormer 1 ur ur æ æ æ æ", 50, 0),
                new Robot("mr.Transormer 2 ur ur æ æ æ æ", 50, 1),
                new Улитка("Лари", 23)
        };

        Obstacle[] obstacle = {
                new Wall(Walll.HIGH),
                new Wall(Walll.HIGH),
                new Wall(Walll.HIGH),
                new Treadmill(TreadmillL.Short),
                new Treadmill(TreadmillL.Middle),
                new Treadmill(TreadmillL.Long),
                };

        for (Member memb : members) {
            for (Obstacle obs : obstacle) {
                if (!obs.isCan(memb)) {
                    break;
                }
            }
        }
    }
}