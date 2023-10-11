package org.example;


public class Main {
    private static int extraJumpCount = 2;
    public static int getExtraJumpCount() {
        return extraJumpCount;
    }

    public static void decrementExtraJumpCount() {
        extraJumpCount--;
    }

    public static void main(String[] args) {
        Member[] members =
                {
                        new Cat("mr.Martin", 50, 3),
                        new Cat("mr.Stepan",50,4),
                        new Person("mr.Roman", 50, 13),
                        new Robot("mr.Transormer 1 ur ur æ æ æ æ", 50, 0),
                        new Robot("mr.Transormer 2 ur ur æ æ æ æ", 50, 1),
                        new Улитка("Лари",23)
                };


        Obstacle[] obstacle =
                {
                        new Treadmill(8),
                        new Wall(Walll.HIGH.getVasota()),
                        new Wall(Walll.LOW.getVasota()),
                        new Wall(Walll.SHORT.getVasota()),
                };

        for (Member memb: members) {
            for (Obstacle obs : obstacle) {
                if (!obs.isCan(memb)) {
                    break;
                }
            }
        }
    }
}