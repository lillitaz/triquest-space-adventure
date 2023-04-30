package com.codecool.mightytextadventure.data;

public enum DisplayElements {

    TITLE("""
            Triquest Space Adventure!
            """),

    MAP("""
                                                   +++++
                                                +              +
                                              +    ESCAPE POD   +
                                              +       \\  ->  \\   +
                                               +_______\\ <-   \\__ +
                                                +                  +
                                                 +     LABORATORY   +
                                                  +                  +
                                                   +       \\  ->  \\    +
                                                    +_______\\ <-   \\ ___ +
                +++++++++++++++++++++++++++++++                             +
            ++  COMMAND     >----+     MED    <------+   >--   GENERATOR      +
            ++  BRIDGE      <____+     BAY    >______+   <--   ROOM           +
                ++++++++++++++++++++++++++++++++                            +
                                                     +_______/  <-  /_____+
                                                    +       /   -> /     +
                                                   +                   +
                                                  +     ARMORY        +
                                                +                   +
                                               +________/ <-   /___+
                                              +        /  ->  /   +
                                              +    LIVING       +
                                                +   QUARTERS  +
                                                    +++++
            """),
    INTRO("""
                You are waking up in the Living Quarters of the Spaceship.
                And have no idea what is going on. You need to find out more...
            """),
    INTRO_SCREEN("""
                                 `. ___
                                __,' __`.                _..----....____
                    __...--.'``;.   ,.   ;``--..__     .'    ,-._    _.-'
              _..-''-------'   `'   `'   `'     O ``-''._   (,;') _,'
            ,'________________                          \\`-._`-','
             `._              ```````````------...___   '-.._'-:
                ```--.._      ,.                     ````--...__\\-.
                        `.--. `-`                       ____    |  |`
                          `. `.                       ,'`````.  ;  ;`
                            `._`.        __________   `.      \\'__/`
                               `-:._____/______/___/____`.     \\  `
                                           |       `._    `.    \\
                                           `._________`-.   `.   `.___
                                                              `------'`
            """),

    INFO_TERMINAL("""
            Attention all astronauts on board the space ship,
                            
            It is with great urgency that we inform you of a highly contagious Alien Virus
            that is spreading rapidly throughout the ship. The virus is extremely dangerous
            and can cause severe illness or even death.
                            
            A Code Red Signal has been sent out, and it is imperative that all crew members
            take immediate action to prevent further spread of the virus.
            Failure to do so will result in the destruction of the ship upon entry.
            In order to contain the virus, all crew members are required to follow strict
            protocols including but not limited to wearing protective gear, avoiding contact
            with infected individuals, and maintaining proper hygiene at all times.
            We urge all crew members to remain vigilant and report any signs of illness
            immediately to the medical team. The safety of the entire crew depends on the
            swift and effective action of each and every individual.
            Thank you for your cooperation and dedication to the safety of the crew.
                            
            Stay safe and stay healthy.
            """),
    QUIT("Sorry to see you go. Bye!"),
    INPUT_ERROR("Unknown command. Try again."),
    ARMORY_CLOSET_TEXT("Locked and Loaded."),
    HEALTH_STATION_TEXT("You take the bandages and patch yourself up."),
    LAB_STATION_THOUGHTS("The Lab Station! It would be a smart choice to check for an infection.\n" +
            " "),
    CONTAMINATION("""
            I have been contaminated, I could use the Lab Station to get rid of the virus.
            But it´s gonna be a coin toss if I survive.
            Should I risk it, or should I take my chances for a safer treatment on earth.
            With the communication down the chances of spreading the infection on earth are rather high.

            Make the call:
            \t1.Risk it.
            \t2.Take your chances.
            """),
    BAD_END("""
            o               .        ___---___                    .                  \s
                   .              .--\\        --.     .     .         .
                                ./.;_.\\     __/~ \\.    \s
                               /;  / `-'  __\\    . \\                           \s
             .        .       / ,--'     / .   .;   \\        |
                             | .|       /       __   |      -O-       .
                            |__/    __ |  . ;   \\ | . |      |
                            |      /  \\\\_    . ;| \\___|   \s
               .    o       |      \\  .~\\\\___,--'     |           .
                             |     | . ; ~~~~\\_    __|
                |             \\    \\   .  .  ; \\  /_/   .
               -O-        .    \\   /         . |  ~/                  .
                |    .          ~\\ \\   .      /  /~          o
              .                   ~--___ ; ___--~      \s
                             .          ---         .         
                             
            You  made it to the Escape Pod. And are safe. 
            But you also risked the virus spreading on earth.
                        
            Nobody knows what will happen once you reach Earth...
            """),
    GOOD_END("""
                    o               .        ___---___                    .                  \s
                           .              .--\\        --.     .     .         .
                                        ./.;_.\\     __/~ \\.    \s
                                       /;  / `-'  __\\    . \\                           \s
                     .        .       / ,--'     / .   .;   \\        |
                                     | .|       /       __   |      -O-       .
                                    |__/    __ |  . ;   \\ | . |      |
                                    |      /  \\\\_    . ;| \\___|   \s
                       .    o       |      \\  .~\\\\___,--'     |           .
                                     |     | . ; ~~~~\\_    __|
                        |             \\    \\   .  .  ; \\  /_/   .
                       -O-        .    \\   /         . |  ~/                  .
                        |    .          ~\\ \\   .      /  /~          o
                      .                   ~--___ ; ___--~      \s
                                     .          ---         .              -
            You made it! And you saved Earth too.
            """),
    ERROR("Error in printing the Message."),
    GAME_MECHANICS("""
            Press:
            + MAP / 4 to open the map
            + GO / 3 to move to the next area
            + INTERACT / 2 to interact with an Object in the Room
            + INSPECT / 1 to see what's is in the current Room and Pick it up
            + QUIT / 5 to End the Game
            + 1 to shot your Weapon
            """),

    ALIEN("""
                 __.,,------.._
                  ,'"   _      _   "`.
                 /.__, ._  -=- _"`    Y
                (.____.-.`      ""`   j
                 VvvvvvV`.Y,.    _.,-'       ,     ,     ,
                    Y    ||,   '"\\         ,/    ,/    ./
                    |   ,'  ,     `-..,'_,'/___,'/   ,'/   ,
               ..  ,;,,',-'"\\,'  ,  .     '     ' ""' '--,/    .. ..
             ,'. `.`---'     `, /  , Y -=-    ,'   ,   ,. .`-..||_|| ..
            ff\\\\`. `._        /f ,'j j , ,' ,   , f ,  \\=\\ Y   || ||`||_..
            l` \\` `.`."`-..,-' j  /./ /, , / , / /l \\   \\=\\l   || `' || ||...
             `  `   `-._ `-.,-/ ,' /`"/-/-/-/-"'''"`.`.  `'.\\--`'--..`'_`' || ,
                        "`-_,',  ,'  f    ,   /      `._    ``._     ,  `-.`'//         ,
                      ,-"'' _.,-'    l_,-'_,,'          "`-._ . "`. /|     `.'\\ ,       |
                    ,',.,-'"          \\=) ,`-.         ,    `-'._`.V |       \\ // .. . /j
                    |f\\\\               `._ )-."`.     /|         `.| |        `.`-||-\\\\/
                    l` \\`                 "`._   "`--' j          j' j          `-`---'
                     `  `                     "`,-  ,'/       ,-'"  /
                                             ,'",__,-'       /,, ,-'
                                             Vvv'            VVv'
                        
                        """),
    YOU_DIED("""
                       
             ▓██   ██▓ ▒█████   █    ██    ▓█████▄  ██▓▓█████ ▓█████▄  ▐██▌
             ▒██  ██▒▒██▒  ██▒ ██  ▓██▒   ▒██▀ ██▌▓██▒▓█   ▀ ▒██▀ ██▌ ▐██▌
             ▒██ ██░▒██░  ██▒▓██  ▒██░   ░██   █▌▒██▒▒███   ░██   █▌ ▐██▌
            ░ ▐██▓░▒██   ██░▓▓█  ░██░   ░▓█▄   ▌░██░▒▓█  ▄ ░▓█▄   ▌  ▓██▒
             ░ ██▒▓░░ ████▓▒░▒▒█████▓    ░▒████▓ ░██░░▒████▒░▒████▓   ▒▄▄
               ██▒▒▒ ░ ▒░▒░▒░ ░▒▓▒ ▒ ▒     ▒▒▓  ▒ ░▓  ░░ ▒░ ░ ▒▒▓  ▒  ░▀▀▒
              ▓██ ░▒░   ░ ▒ ▒░ ░░▒░ ░ ░     ░ ▒  ▒  ▒ ░ ░ ░  ░ ░ ▒  ▒  ░  ░
              ▒ ▒ ░░  ░ ░ ░ ▒   ░░░ ░ ░     ░ ░  ░  ▒ ░   ░    ░ ░  ░     ░
             ░ ░         ░ ░     ░           ░     ░     ░  ░   ░     ░
             ░ ░                           ░                  ░
                     """);
    private final String element;

    DisplayElements(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }
}
