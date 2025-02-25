//we need to import the random library so we can get a random word
import java.util.Random;

public class Word {

    //this word array contains all of the words that can appear in the game
    String[] words = {
"arm",
"back",
"ears",
"eyes",
"face",
"feet",
"fingers",
"foot",
"hair",
"hands",
"head",
"knees",
"legs",
"mouth",
"neck",
"nose",
"shoulders",
"skin",
"stomach",
"teeth",
"thumbs",
"toes",
"tongue",
"tooth",
"black",
"blue",
"brown",
"grey",
"green",
"orange",
"pink",
"purple",
"red",
"white",
"yellow",
"sunday",
"monday",
"tuesday",
"wednesday",
"thursday",
"friday",
"saturday",
"one",
"two",
"three",
"one",
"five",
"six",
"seven",
"eight",
"nine",
"ten",
"eleven",
"twelve",
"thirteen",
"fourteen",
"fifteen",
"sixteen",
"seventeen",
"eighteen",
"nineteen",
"twenty",
"alligator",
"ant",
"bear",
"bee",
"bird",
"camel",
"cat",
"cheetah",
"chicken",
"chimpanzee",
"cow",
"crocodile",
"deer",
"dog",
"dolphin",
"duck",
"eagle",
"elephant",
"fish",
"fly",
"fox",
"frog",
"giraffe",
"goat",
"goldfish",
"hamster",
"horse",
"kangaroo",
"kitten",
"lion",
"lobster",
"monkey",
"octopus",
"owl",
"panda",
"pig",
"puppy",
"rabbit",
"rat",
"scorpion",
"seal",
"shark",
"snail",
"snake",
"spider",
"squirrel",
"tiger",
"turtle",
"wolf",
"zebra",
"blackboard",
"book",
"bookcase",
"calendar",
"chair",
"chalk",
"clock",
"computer",
"desk",
"dictionary",
"eraser",
"map",
"notebook",
"pen",
"pencil",
"textbook",
"bill",
"breakfast",
"check",
"cup",
"dessert",
"dinner",
"dressing",
"drink",
"hamburger",
"knife",
"lunch",
"menu",
"napkin",
"order",
"salt",
"spoon",
"water",
"coffee",
"tea",
"clear",
"cloudy",
"cold",
"cool",
"foggy",
"hot",
"humid",
"rainy",
"snowy",
"stormy",
"sunny",
"warm",
"windy",
"asparagus",
"beans",
"broccoli",
"cabbage",
"carrot",
"celery",
"corn",
"cucumber",
"eggplant",
"lettuce",
"onion",
"peas",
"potato",
"pumpkin",
"spinach",
"tomato",
"airplane",
"bicycle",
"boat",
"bus",
"car",
"helicopter",
"horse",
"jet",
"motorcycle",
"ship",
"subway",
"taxi",
"train",
"truck",
"plane",
"saw",
"drill",
"hammer"
};

    //creates a random number 
    Random random = new Random();
    int randint = random.nextInt(words.length);

    //gets a random word from our words array
    String word = words[randint];

    //this method returns the word in the form of a character array
    public char[] chararray() {
        return word.toCharArray();
    }
}

