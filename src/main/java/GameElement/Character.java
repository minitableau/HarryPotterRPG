package GameElement;

import Level.Level2;
import utils.ConsoleColors;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static Level.Level1.listFriendsWithYou;

public abstract class Character {

    private int lifePoint;
    private int maxLifePoint;

    private final String name;

    private int accuracyBonus;

    private int powerBonus;

    private int efficiencyPotionsBonus;

    private int resistanceBonus;
    private int mana;

    private int money;

    private boolean isAlive;


    public Character(int lifePoint, int maxLifePoint, String name, int accuracyBonus, int powerBonus, int efficiencyPotionsBonus, int resistanceBonus, int mana, int money, boolean isAlive) {
        this.lifePoint = lifePoint;
        this.maxLifePoint = maxLifePoint;
        this.name = name;
        this.accuracyBonus = accuracyBonus;
        this.powerBonus = powerBonus;
        this.efficiencyPotionsBonus = efficiencyPotionsBonus;
        this.resistanceBonus = resistanceBonus;
        this.mana = mana;
        this.money = money;
        this.isAlive = isAlive;
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }

    public int getMaxLifePoint() {
        return maxLifePoint;
    }

    public void setMaxLifePoint(int maxLifePoint) {
        this.maxLifePoint = maxLifePoint;
    }

    public String getName() {
        return name;
    }

    public int getAccuracyBonus() {
        return accuracyBonus;
    }

    public void setAccuracyBonus(int accuracyBonus) {
        this.accuracyBonus = accuracyBonus;
    }

    public int getPowerBonus() {
        return powerBonus;
    }

    public void setPowerBonus(int powerBonus) {
        this.powerBonus = powerBonus;
    }

    public int getEfficiencyPotionsBonus() {
        return efficiencyPotionsBonus;
    }

    public void setEfficiencyPotionsBonus(int efficiencyPotionsBonus) {
        this.efficiencyPotionsBonus = efficiencyPotionsBonus;
    }

    public int getResistanceBonus() {
        return resistanceBonus;
    }

    public void setResistanceBonus(int resistanceBonus) {
        this.resistanceBonus = resistanceBonus;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean alive) {
        isAlive = alive;
    }

    //    public void attack(Character character) {
//        //Gérer deux cas : Wizard ou AbstractEnemy
//
//    }
    private static boolean wizardAttackTroll(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;
        boolean comeback = true;

        while (comeback) {
            String stats = wizard.stats(wizard.getName(), wizard.getLifePoint(), wizard.getMaxLifePoint(), wizard.getMana(), wizard.getResistanceBonus(), wizard.getPowerBonus(), wizard.getAccuracyBonus(), wizard.getEfficiencyPotionsBonus(), wizard.getMoney());
            System.out.println(stats);
            System.out.println(ConsoleColors.BLUE + "\nQue voulez-vous faire sachant que le " + enemy.getName() + " se situe à " + enemy.getDistance() + " mètres et à " + enemy.getLifePoints() + " points de vie ?" + ConsoleColors.RESET);
            System.out.println("1 : Jeter des bouts de bois"); //action dif
            System.out.println("2 : Se rapprocher");
            System.out.println("3 : Utiliser un sort");
            System.out.println("4 : Ouvrir votre sac");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice < 1 || choice > 4) {
                    System.out.println("Le choix doit être 1, 2, 3 ou 4.");
                    continue;
                }

                switch (choice) {
                    case 1 -> { //dif
                        int dommage = 20 + (20 * wizard.getPowerBonus()) / 100;
                        System.out.println("Vous jetez des bouts de bois sur le troll. Il perd " + dommage + " points de vie");
                        enemy.setLifePoints(enemy.getLifePoints() - dommage);
                        if (enemy.getLifePoints() <= 0) {
                            return true;
                        }
                        comeback = false;
                    }
                    case 2 -> {
                        System.out.println("Vous vous rapprochez du " + enemy.getName() + ".");
                        enemy.setDistance(enemy.getDistance() - 1);
                        comeback = false;
                    }
                    case 3 -> {
                        comeback = spellList(wizard, enemy);
                        if (enemy.getLifePoints() <= 0) {
                            return true;
                        }
                    }
                    case 4 -> {
                        comeback = Backpack.openBackpack(wizard, enemy);
                    }

                }


            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }
            if (enemy.getDistance() == 1 && Level2.tooth) {
                System.out.println("Vous ramassez la dent du basilic pour le frappez ce qui lui enlève 50 points de vie.");
                enemy.setLifePoints(enemy.getLifePoints() - 50 - (50 * wizard.getPowerBonus()) / 100);
                if (enemy.getLifePoints() > 0) {
                    System.out.println("mais celui-ci riposte,vous lâchez la dents et vous êtes repoussé d'un mètre.");
                    enemy.setDistance(2);
                } else {
                    return true;
                }


            }
        }
        return false;
    }

    private static boolean wizardAttackBasilic(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;
        boolean comeback = true;

        while (comeback) {
            String stats = wizard.stats(wizard.getName(), wizard.getLifePoint(), wizard.getMaxLifePoint(), wizard.getMana(), wizard.getResistanceBonus(), wizard.getPowerBonus(), wizard.getAccuracyBonus(), wizard.getEfficiencyPotionsBonus(), wizard.getMoney());
            System.out.println(stats);
            System.out.println(ConsoleColors.BLUE + "\nQue voulez-vous faire sachant que le " + enemy.getName() + " se situe à " + enemy.getDistance() + " mètres et à " + enemy.getLifePoints() + " points de vie ?" + ConsoleColors.RESET);
            System.out.println("1 : Jeter des pierres"); //action dif
            System.out.println("2 : Se rapprocher");
            System.out.println("3 : Utiliser un sort");
            System.out.println("4 : Ouvrir votre sac");


            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice < 1 || choice > 4) {
                    System.out.println("Le choix doit être 1, 2, 3 ou 4.");
                    continue;
                }

                switch (choice) {
                    case 1 -> { //dif
                        int dommage = 1 + (1 * wizard.getPowerBonus()) / 100;
                        System.out.println("Vous jetez des pierre sur le Basilic. Il perd " + dommage + " points de vie");
                        enemy.setLifePoints(enemy.getLifePoints() - dommage);
                        if (enemy.getLifePoints() <= 0) {
                            return true;
                        }
                        comeback = false;
                    }
                    case 2 -> {
                        System.out.println("Vous vous rapprochez du " + enemy.getName() + ".");
                        enemy.setDistance(enemy.getDistance() - 1);
                        comeback = false;
                    }

                    case 3 -> {
                        comeback = spellList(wizard, enemy);
                        if (enemy.getLifePoints() <= 0) {
                            return true;
                        }
                    }
                    case 4 -> {
                        comeback = Backpack.openBackpack(wizard, enemy);
                    }

                }


            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }

            if (enemy.getDistance() == 1 && Level2.tooth) {
                System.out.println("Vous ramassez la dent du basilic pour le frappez ce qui lui enlève 50 points de vie.");
                enemy.setLifePoints(enemy.getLifePoints() - 50 - (50 * wizard.getPowerBonus()) / 100);
                if (enemy.getLifePoints() > 0) {
                    System.out.println("mais vous repoussez d'un mètre.");
                    enemy.setDistance(2);
                } else {
                    return true;
                }


            }
        }
        return false;
    }

    private static boolean wizardAttacksWho(Wizard wizard, Enemy enemy) {
        if (enemy == Enemy.troll) {
            return wizardAttackTroll(wizard, enemy);
        } else if (enemy == Enemy.basilic) {
            return wizardAttackBasilic(wizard, enemy);
        }

        return false; // inutile
    }

    private static boolean whoAttacksWizard(Wizard wizard, Enemy enemy) {
        if (enemy == Enemy.troll) {
            return trollAttackWizard(wizard, enemy);
        } else if (enemy == Enemy.basilic) {
            return basilicAttackWizard(wizard, enemy);
        }

        return false; // inutile
    }

    private static boolean trollAttackWizard(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        int wizardLife = wizard.getLifePoint();
        int chanceOfSuccess = 0;
        chanceOfSuccess = 40 + listFriendsWithYou(wizard).size() * 20;
        System.out.println("\nVous êtes " + (int) (listFriendsWithYou(wizard).size() + 1) + " contre le troll. La probabilité qu'il vous touche est de " + chanceOfSuccess + "%.");
        Random random = new Random();
        int randomValue = random.nextInt(101);
        if (randomValue <= chanceOfSuccess) {
            int dommage = Enemy.troll.getDommage() - (Enemy.troll.getDommage() * wizard.getResistanceBonus()) / 100;
            wizard.setLifePoint(wizardLife - dommage);
            System.out.println("La massue du troll, vous frappe et vous enlève " + dommage + " points de vie.");
            if (wizard.getLifePoint() <= 0) {
                System.out.println("Vous êtes mort! Le troll vous a vaincu.");
                return true;
            }
        } else {
            System.out.println("Le troll essaie de vous frapper avec ca massue mais vous arrivez à l'éviter.");
        }
        return false;
    }

    private static boolean basilicAttackWizard(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        int wizardLife = wizard.getLifePoint();
        int chanceOfSuccess = 0;
        chanceOfSuccess = 70;
        System.out.println("\nLa probabilité qu'il vous touche est de " + chanceOfSuccess + "%.");
        Random random = new Random();
        int randomValue = random.nextInt(101);
        if (randomValue <= chanceOfSuccess) {
            int dommage = Enemy.basilic.getDommage() - (Enemy.basilic.getDommage() * wizard.getResistanceBonus()) / 100;
            wizard.setLifePoint(wizardLife - dommage);
            System.out.println("La queue du Basilic, vous frappe et vous enlève " + dommage + " points de vie.");
            if (wizard.getLifePoint() <= 0) {
                System.out.println("Vous êtes mort! Le basilic vous a vaincu.");
                return true;
            }
        } else {
            System.out.println("Le basilic essaie de vous frapper avec ca queue mais vous arrivez à l'éviter.");
        }
        return false;
    }

    private static boolean spellList(Wizard wizard, Enemy enemy) {
        int numSpells = wizard.getKnownSpells().size();
        if (numSpells == 0) {
            System.out.println("Vous n'avez appris aucun sort.");
            return true;
        } else {
            System.out.println(ConsoleColors.BLUE + "\nVeuillez choisir un sort :" + ConsoleColors.RESET);
            for (int i = 0; i < numSpells; i++) {
                System.out.println((i + 1) + " : " + wizard.getKnownSpells().get(i).getName());
            }
            System.out.println((numSpells + 1) + " : Ne pas utiliser de sort.");
            int choice = -1;
            do {
                Scanner scanner = new Scanner(System.in);
                try {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > numSpells + 1) {
                        System.out.println("Veuillez entrer un choix valide.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer un choix valide.");
                    scanner.next();
                }
            } while (choice < 1 || choice > numSpells + 1);
            if (choice == numSpells + 1) {
                return true;
            }
            Spell chosenSpell = wizard.getKnownSpells().get(choice - 1);
            System.out.println("Vous avez choisi le sort " + chosenSpell.getName() + ".");
            if (chosenSpell == Spell.windgardiumLeviosa && Enemy.troll == enemy) {
                int chanceOfSuccess = 0;
                if (enemy.getDistance() <= 7) {
                    System.out.println("Vous utilisez Windgardium Leviosa sur la massue du troll !");
                    chanceOfSuccess = 100 - (enemy.getDistance() * 5) + wizard.getAccuracyBonus();
                    System.out.println("Vous êtes à " + enemy.getDistance() + " mètres du troll. Votre chance de réussite est de " + chanceOfSuccess + "%.");
                    Random random = new Random();
                    int randomValue = random.nextInt(101);
                    if (randomValue <= chanceOfSuccess) {
                        System.out.println("Votre sort atteint la massue du troll, vous diriger alors la massue plusieurs mètres au dessus de ca tete et la laisser tombé ce qui assomme le troll.");
                        enemy.setLifePoints(0);
                        return true;
                    } else {
                        System.out.println("Vous ratez votre sort de justesse.");
                    }
                } else {
                    System.out.println("Vous êtes à " + enemy.getDistance() + " mètres du troll. Votre chance de réussite est de " + chanceOfSuccess + "%., si vous aviez mieux écouter le cours vous sauriez que pour utiliser Windgarium leviosa \nil faut etre à 7 mètres ou moins pour que le sort est une chance de reussir et que plus vous etes proche plus vous augementer vos chances.");
                }
            } else if (chosenSpell == Spell.aloomora) {
                //effet aloomora
            } else if (chosenSpell == Spell.immobulus) {
                // effet imobulus
            } else if (chosenSpell == Spell.accio && enemy == Enemy.basilic) {
                int chanceOfSuccess = 0;
                if (enemy.getDistance() <= 7) {
                    System.out.println("Vous utilisez Accio en visant la machoire du basilic !");
                    chanceOfSuccess = 100 - (enemy.getDistance() * 5) + wizard.getAccuracyBonus();
                    System.out.println("Vous êtes à " + enemy.getDistance() + " mètres du basilic. Votre chance de réussite est de " + chanceOfSuccess + "%.");
                    Random random = new Random();
                    int randomValue = random.nextInt(101);
                    if (randomValue <= chanceOfSuccess) {
                        System.out.println("Votre sort atteint les dents du basilic, une d'entre elles se décroche commence à venir vers vous mais vous la faite tomber au sol à 1m du basilic.");
                        Level2.tooth = true;
                        return true;
                    } else {
                        System.out.println("Vous ratez votre sort de justesse.");
                    }
                }
            }
            System.out.println("Votre sort n'a rien fait au " + enemy.getName());
        }
        return false;
    }

    public static void fight(Wizard wizard, Enemy enemy, List<Friend> listFriendsWithYou) {
        boolean enemyAlive = false;
        boolean wizardAlive = false;
        while (enemy.getDistance() >= 1 && !enemyAlive && !wizardAlive) {
            enemyAlive = wizardAttacksWho(wizard, enemy);
            if (enemy.getDistance() < 1) {
                wizardAlive = true;
                break;
            }
            if (enemyAlive || enemy.getLifePoints() <= 0) {
                break;
            }
            for (int i = 0; i < listFriendsWithYou.size(); i++) {
                System.out.println("\nVotre ami " + listFriendsWithYou.get(i).getName() + " peut aussi attaquer le " + enemy.getName() + ".");
                enemyAlive = wizardAttacksWho(wizard, enemy);
                if (enemy.getDistance() < 1) {
                    wizardAlive = true;
                    break;
                }
                if (enemyAlive) {
                    break;
                }
            }
            if (enemy.getDistance() < 1) {
                wizardAlive = true;
                break;
            }
            if (enemyAlive || enemy.getLifePoints() <= 0) {
                break;
            }
            wizardAlive = whoAttacksWizard(wizard, enemy);

        }

        if (enemy.getDistance() < 1) {
            wizard.setLifePoint(0);
            System.out.println("Quel idée de se coller au " + enemy.getName() + " ! Celui-ci vous mange.");
        }

        if (enemyAlive || enemy.getLifePoints() <= 0) {
            System.out.println("Vous avez vaincu le " + enemy.getName() + " !");
        }
    }

}
