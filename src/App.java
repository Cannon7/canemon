import java.util.Scanner;
import java.util.Random;
public class App
 {
    Random random = new Random();
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the copyright free world of Canemon! In this world, there are mythical creatures called Canemon. These creatures are beloved by Canemon trainers around the world. Your destiney is to become the best Canemon trainer the world will ever see!");
        System.out.println("What is your name trainer?");
        String name = input.nextLine();
        System.out.println("Greetings " + name + ", It's great to meet a hero in the making!");
        int check = 1;
        int maxHP = 0;
        int DEF = 0;
        int ATK = 0;
        String canemonname = "";
        String weakness = "";
        String resist = "";
        int tackle = 50;
        int elementalpwr = 50;
        String elem = "";
        while (check < 2)
        {
            System.out.println("Well lets get greetings out of the way, I know the only reason you're here is to recieve your first Canemon! ");
            System.out.println("First, we have Canchar the fire type Canemon. He is very attack oriented and has low defense and HP. To choose press 1");
            System.out.println("Second, we have Canfern the grass type Canemon. She is very HP oriented and has low defense and attack. To choose press 2");
            System.out.println("Third, we have Canpuddle the water type Canemon. He is very defense oriented and has low attack and HP. To choose press 3");
            String choice = input.nextLine();
            if (choice.equals("1"))
            {    maxHP = 50;
                DEF = 30;
                ATK = 70;
                check = 4;
                canemonname = "Canchar";
                weakness = "water";
                resist = "grass";
                elem = "fire";
            }  
            if (choice.equals("2"))
            {
                maxHP = 80;
                DEF = 20;
                ATK = 50;
                check = 4;
                canemonname = "Canfern";
                weakness = "fire";
                resist = "water";
                elem = "grass";
            }
            if (choice.equals("3"))
            {
                maxHP = 50;
                DEF = 35;
                ATK = 50;
                check = 4;
                canemonname = "Canpuddle";
                weakness = "grass";
                resist = "fire";
                elem = "water";
            }
        }
        int HP = maxHP;
        System.out.println("Ah yes, " + canemonname + "! What a great Canemon you have chosen.");
        System.out.println("Well onto our next lesson! Canemon can be one of 4 types. Water, Fire, Grass, and normal.");
        System.out.println("Fire is weak to water but strong against grass.");
        System.out.println("Water is weak to grass but strong against fire.");
        System.out.println("grass is weak to fire but strong against water.");
        System.out.println("Normal has no strengths or weakness'");
        System.out.println("Did you get all that?");
        String wait = input.nextLine();
        System.out.println("Good, now lets move into your first battle");
        int oDEF = 30;
        int oHP = 60;
        boolean win = false;
        String oweakness = "fire";
        String oresist = "water";
        int odamage = oHP;
        int damage = HP;
        System.out.println("You are challenged by Prof. Cannon");
        System.out.println("He uses the Canemon Leafalo ");
        while (HP > 0)
        {
            check = 4;
            while (check < 6)
            {
                System.out.println("You have acess to two moves, (1)Tackle and (2)Elemental Power. press 1 or 2 to attack");
                String choice = input.nextLine();
                if (choice.equals("1"))
                {    
                    check = 7;
                    oHP = Battleturn("normal", tackle, oweakness, oresist, oHP, oDEF);
                    System.out.println("your attack did " + (odamage - oHP) + " damage!");
                }  
                if (choice.equals("2"))
                {    
                    check = 7;
                    oHP = Battleturn(elem, elementalpwr, oweakness, oresist, oHP, oDEF);
                    System.out.println("your attack did " + (odamage - oHP) + " damage!");
                }  
                odamage = oHP;
                if (oHP <= 0)
                {
                    System.out.println("Leafalo fainted!");
                    win = true;
                    HP = -1;
                }
            }
            if (oHP > 0)
            {
                System.out.println("Leafalo used leaf slam!");
                HP = oBattleturn("grass", 40, weakness, resist, HP, DEF);
                System.out.println("The attack did " + (damage - HP) + " damage!");
                damage = HP;
            }
        }
        if (win)
        {
            System.out.println("Congrats you win!");
        }
        else
        {
            System.out.println("Your " + canemonname + " has fainted!");
            System.out.println("You have lost, better luck next time.");
        }
        System.out.println("GAME OVER");
        input.close();
    }
    public static int Battleturn(String Movetype, int Movepwr, String oweakness, String oresist, int oHP, int oDEF)
    {
        if (Movetype.equals(oweakness))
        {
            System.out.println("ITS SUPER EFFECTIVE!");
            Movepwr = Movepwr * 2;
        }
        if (Movetype.equals(oresist))
        {
            System.out.println("its not very effective...");
            Movepwr = Movepwr / 2;
            Movepwr = Movepwr + 10;
        }
        Movepwr = Movepwr - oDEF;
        oHP = oHP - Movepwr;
        return oHP;
    }
    public static int oBattleturn(String oMovetype, int oMovepwr, String weakness, String resist, int HP, int DEF)
    {
        if (oMovetype.equals(weakness))
        {
            System.out.println("ITS SUPER EFFECTIVE!");
            oMovepwr = oMovepwr * 2;
        }
        if (oMovetype.equals(resist))
        {
            System.out.println("its not very effective...");
            oMovepwr = oMovepwr / 2;
        }
        oMovepwr = oMovepwr - DEF;
        HP = HP - oMovepwr;
        return HP;
    }
}
