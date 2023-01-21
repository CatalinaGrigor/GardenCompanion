package com.example.gardencompanion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

import com.example.gardencompanion.modele.DbAdapter;
import com.example.gardencompanion.modele.Plante;

public class SplashActivity extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;
    private DbAdapter dbAdapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);

        dbAdapter = new DbAdapter(SplashActivity.this);
        remplirTable();
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActivity.this, Menu.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    private void remplirTable() {
        this.dbAdapter.ajouterPlante(new Plante("Betterave","\n " +
                "Exposition\n" +
                "La betterave fait aussi" +
                " partie de la liste de légumes qui poussent à l’ombre. Son joli feuillage veiné" +
                " de rouge orne le potager à l’ombre quand la majorité des autres légumes ont été" +
                " récoltés. \n" +
                "\n" +
                "Sol\n" +
                "\n" +
                "Légume riche en minéraux et en vitamines, la betterave apprécie les " +
                "sols riches, l’arrosage régulier et l’exposition- soleil/ombre légère.",
                "Brocoli,\n Chou,\n Chou-fleur,\n Laitue,\n Oignons,\n " +
                        "Pomme de terre,\n Sauge",
                "Tomate"));
        this.dbAdapter.ajouterPlante(new Plante("Brocoli","\nLe chou brocoli est un" +
                " légume facile de culture, savoureux et reconnaissable à son inflorescence verte.\n" +
                "\n" +
                " Sol\n"+
                "\n Riche en vitamines, même après cuisson, le chou brocoli peut pousser pratiquement" +
                " partout. Il préfère quand même les sols frais et profonds, les arrosages réguliers.\n" +
                " \n" +
                "Exposition\n" +
                "Partiellement ombragée.",
                "Betterave,\n Carottes,\n Concombre,\n Haricots,\n Pomme de terre",
                "Fraise,\n Poivron,\n Tomate,\n  Haricots,\n Laitue,\n Poireau"));
        this.dbAdapter.ajouterPlante(new Plante("Chou-fleur","\nPauvre en calories et " +
                "riche en fibres et en minéraux, le chou-fleur est un excellent choix pour tout " +
                "potager. \n\n" +
                "Exposition\n\n" +
                "Il préfère l’exposition ensoleillée ou mi-ombragée.\n\n" +
                " Sol\n" +
                " \n Il aime les sols profonds, frais et riches.",
                "Betterave,\n Celeri,\n Concombre,\n Haricots,\n Pomme de terre,\n" +
                        " Tomate",
                "Fraise\n, Tomate "));
        this.dbAdapter.ajouterPlante(new Plante("Carotte","\n" +
                "Sol\n\nLa culture des carottes" +
                " demande un sol profond, meuble, fertile et léger, permettant un drainage naturel." +
                " \nL'absence de cailloux, graviers, mottes et autres obstacles est nécessaire pour" +
                " éviter que les carottes fourchent. \nLe sol idéal est sablonneux, bien drainé ou" +
                " tourbeux, mais les carottes peuvent pousser sur sol lourd si elles sont" +
                " cultivées en conséquence.\n\nExposition\n\n La carotte préfère le plein soleil " +
                "(au moins 6 heures de soleil par jour). \nElle poussera aussi à la mi-ombre, " +
                "mais plus lentement.",
                "Concombre,\n Haricots,\n Laitue,\n Oignons,\n Pois,\n Radis,\n Sauge," +
                        " \nTomate",
                "Persil"));
        this.dbAdapter.ajouterPlante(new Plante("Celeri","\n" +
                "Exposition\n" +
                "\n" +
                "Il a besoin de soleil pour un feuillage abondant et parfumé. La mi-ombre légère" +
                " est possible dans le Sud.\n" +
                "\n" +
                "Sol\n" +
                "\n" +
                "Offrez au céleri-branche comme au céleri-rave un sol toujours frais, humifère, " +
                "meuble et fertile.",
                "Chou,\n Chou-fleur,\n Pois,\n Tomate",
                "Pomme de terre,\n Laitue "));
        this.dbAdapter.ajouterPlante(new Plante("Haricots","\n" +
                "Les haricots verts sont parmi les légumes les plus faciles à faire pousser.\n " +
                "La diversité impressionnante de variétés en terme de goûts, formes et couleurs, " +
                "confère aux haricots une place incontournable dans le potager. La plante est " +
                "décidément adepte de la chaleur- elle ne supporte pas les températures fraîches e" +
                "t le gel.\n" +
                "\n" +
                "Exposition\n" +
                "\n" +
                "L’idéal serait " +
                "de choisir un coin ensoleillé ou mi-ombragé, dont le sol est humide.",
                "Chou,\n Chou-fleur,\n Pois,\n Tomate",
                "Pomme de terre,\n Laitue "));
        this.dbAdapter.ajouterPlante(new Plante("Ciboulette","\n" +
                "Exposition\n" +
                "\n" +
                "La ciboulette a besoin d'une bonne luminosité, toutefois il faudra éviter de " +
                "l'exposer directement au soleil en début de culture. \nMais elle supporte" +
                " la mi-ombre ou l'ombre, plantées dans une terre plutôt riche, fraîche.",
                "Asperge,\n Carottes,\n Fraise,\n Tomate",
                "Haricots\n, Pois "));

        this.dbAdapter.ajouterPlante(new Plante("Mais","\n" +
                "Sol\n" +
                "\n" +
                "Le maïs apprécie un sol profond, riche (compost, fumier à l'automne), " +
                "bien travaillé (bêchez le sol avant l'hiver).\n" +
                "Exposition\n" +
                "\n" +
                "Le mais prefere une situation ensoleillée. \n" +
                "La culture de 3 soeurs (mais, " +
                "haricot, courge) est une bonne technique a utiliser pour optimiser l'espace dans " +
                "son jardin.",
                "Concombre,\n Haricots,\n Pois,\n Pomme de terre,\n Radis,\n Zucchini ",
                "Tomate"));
        this.dbAdapter.ajouterPlante(new Plante("Ail",
                "\nExposition en plein soleil.  " +
                        "\n\n" +
                        "Sol\n" +
                        "\n" +
                        " Dans un sol léger, fertile, riche en humus et qui se draine bien. \n" +
                        "Évitez les milieux ombragés et les sols humides qui favorisent les maladies " +
                        "fongiques.\n Pour améliorer le drainage en sol argileux, il est conseillé de " +
                        "planter l'ail sur des billons surélevés.\n",
                "Chou,\n Tomate",
                "Haricots,\n Pois"));
        this.dbAdapter.ajouterPlante(new Plante("Kale","\n" +
                "\nExposition\n\n Plantez-le de préférence au soleil (à défaut, " +
                "la mi-ombre peut aussi lui convenir).  " +
                "\n\n" +
                "Sol\n\n" +
                " Le chou kale apprécie les sols riches et argileux, mais il pourra s'accommoder " +
                "de la plupart des terres.\nSa seule réelle exigence concerne le climat : " +
                "il réussit mal sous les climats trop chauds et préfère la fraîcheur.",
                "Chou,\n Concombre,\n Oignons,\n Pomme de terre,\n Epinards",
                "Fraise"));
        this.dbAdapter.ajouterPlante(new Plante("Laitue","\n" +
                "\nExposition\n\n Elle préfère les situations ombragées et apprécie " +
                "les apports d’eau réguliers.  " +
                "\n\n" +
                "Sol\n\n" +
                " La laitue cultivée apprécie les sols bien travaillés, enrichis de compost.",
                "Betterave, \nCarottes, \nChou,\n Concombre,\n Fraise,\n Oignons,\n" +
                        " Radis",
                "Persil, \nCeleri, \nCresson,"));
        this.dbAdapter.ajouterPlante(new Plante("Oignons","\n" +
                "\nExposition\n\n Elle préfère les situations ombragées et apprécie " +
                "les apports d’eau réguliers.  " +
                "\n\n" +
                "Sol\n\n" +
                " La laitue cultivée apprécie les sols bien travaillés, enrichis de compost.",
                "Betterave,\n Carottes, \nChou,\n Epinards,\n Fraise,\n Laitue,\n" +
                        " Panais,\n Persil ",
                "Haricots,\n Pois"));
        this.dbAdapter.ajouterPlante(new Plante("Persil","\n" +
                "\nExposition\n\n Il préfère la mi-ombre en été mais l'ensoleillement " +
                "le reste de l'année. " +
                "\n\n" +
                "Sol\n\n" +
                "  Le persil se plait dans les sols profonds, frais, riche en humus et d'une" +
                " consistance légère.",
                "Asperge, \nCiboulette,\n Mais,\n Oignons,\n Tomate ",
                "Haricots,\n Pois"));
        this.dbAdapter.ajouterPlante(new Plante("Panais","\n" +
                "\nExposition\n\n Une exposition ensoleillée. " +
                "\n\n" +
                "Sol\n\n" +
                "  Il apprécie les sols bien ameublis car les cailloux gênent le développement" +
                " de belles racines. Idéalement, un sol léger, sableux, bien drainé, enrichi en" +
                " compost l'année précédente, conviendra au panais.",
                "Ciboulette,/n Haricots,/n Mais,\n Oignons,\n Pomme de terre,\n Radis  ",
                "Carotte, \nCeleri\n Fenouil"));
        this.dbAdapter.ajouterPlante(new Plante("Poivron","\n" +
                "\nExposition\n\nLe poivron (Capsicum annuum) apprécie le soleil : " +
                "ne le cultivez que si vous pouvez lui donner un emplacement ensoleillé.  " +
                "\n\n" +
                "Sol\n\n" +
                "  Le poivron aime les terres profondes, richement amendée à l'automne précédent en compost. ",
                "Basilic,\n Coriandre, \nHaricots, \nOignons, \nPersil,\n Tomate   ",
                "Betterave, \nChou-rave,\n Fenouil,\n Moutarde "));
        this.dbAdapter.ajouterPlante(new Plante("Pomme de terre","\n" +
                "\nExposition\n\n Un emplacement au soleil  " +
                "\n\n" +
                "Sol\n\n" +
                "  Le sol doit etre léger, peu argileux et peu humide. Ce serait une bonne idée " +
                "d'ajouter du compost et du fumier à la terre quelques jours avant la plantation, " +
                "car les pommes de terre s'épanouissent dans un sol riche ",
                "Basilic,\n Betteraves,\n Brocoli,\n Chou,\n Chou-fleur,\n Haricots,\n" +
                        " Mais,\n Pois  ",
                "Celeri, \nConcombre,\n Tomate,\nAubergine,\n" +
                        " Citrouille,\n Concombre,\n Courge,\n Epinard  "));
        this.dbAdapter.ajouterPlante(new Plante("Radis","\n" +
                "\nExposition\n\n Un emplacement au soleil, mais elle pousse aussi tres bien a la mi-ombre.  " +
                "\n\n" +
                "Sol\n\n" +
                "  Un sol meuble et frais. Le radis craint la sécheresse. ",
                "Carotte,\n Concombre,\n Laitue,\n Mais,\n Pois ",
                "Pomme de terre, \nHysope\n Vigne  "));
        this.dbAdapter.ajouterPlante(new Plante("Epinard","\n" +
                "\nExposition\n\n Ombragée si on a semé au printemps, ensoleillée si on a semé en automne.   " +
                "\n\n" +
                "Sol\n\n" +
                " Sol assez humide mais bien drainé. ",
                "Celeri, \nChou-fleur,\n Fraise, \nPois ",
                "Laitue "));
        this.dbAdapter.ajouterPlante(new Plante("Tomate","\n" +
                "\nExposition\n\n Choisissez un emplacement bien ensoleillé, " +
                "minimum 6 à 8 heures de soleil, et à l'abri du vent.   " +
                "\n\n" +
                "Sol\n\n" +
                " Le sol doit être toujours humide, sans que vos racines baignent dans l’eau," +
                " au risque d’asphyxier la plante de tomate.\n" +
                "\n" +
                "La terre doit être meuble, afin que les racines de vos plants de " +
                "tomates puissent se développer sans effort. ",
                "Basilic,\n Carotte,\n Celeri,\n Ciboulette,\n Oignons,\n Persil,\n" +
                        " Poivron",
                "Aneth,\n Betterave,\n Brocoli,\n Chou-fleur,\n Fenouil, \nMais," +
                        " Moutarde,\n Oseille, \nPomme de terre  "));
        this.dbAdapter.ajouterPlante(new Plante("Concombre","\n" +
                "\nExposition\n\n  Une exposition ensoleillée et beaucoup de chaleur avec " +
                "de bons arrosages en été.   " +
                "\n\n" +
                "Sol\n\n" +
                " Les concombres et cornichons aiment un sol léger, frais et riche en humus " +
                "et bien ameubli.  ",
                "Basilic,\n Chou,\n Carotte, \nChou-fleur, \nHaricots,\n Laitue,\n" +
                        " Mais,\n Pois,\n Radis",
                "Pomme de terre,\n Sauge,\nCourgette "));

    }

}