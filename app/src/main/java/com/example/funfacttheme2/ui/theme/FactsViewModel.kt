package com.example.funfacttheme2.ui.theme

import androidx.lifecycle.ViewModel

class FactsViewModel : ViewModel() {

    fun generateRandomFacts(selectedAnimal:String) :String{
        return if (selectedAnimal == "Dog"){
            getDogFacts().random()
        }else {
            getCatFacts().random()
        }
    }
}


fun getDogFacts(): List<String> {
    val dogFacts = listOf(
        "Dogs have a 'ruff' time understanding why squirrels don't want to play fetch.",
        "If dogs could text, their messages would be mostly 'food', 'walk', and 'belly rubs?.",
        "To a dog, a car is like the ultimate roller coaster.",
        "Dogs have a secret meeting every night to discuss their strategy for stealing socks.",
        "The only alarm clocks that can wag their tails and demand belly rubs.",
        "Dogs believe that the floor is made of lava, but only when the vaccum is running.",
        "If dogs could talk, they'd probably just ask for more treats.",
        "Dogs have a 'pawsitive' outlook on life.",
        "Dogs think we're amazing just because we can open a can.",
        "The real reason dogs stick their heads out of car windows? The wind is like their version of Noise."
    )
    return dogFacts
}


fun getCatFacts(): List<String> {
    val catFacts = listOf(
        "Cats believe that knocking things off tables is a form of interior decorating.",
        "If cats had a motto, it would be 'Napping is life.'",
        "Cats consider cardboard boxes to be 5-star accommodations.",
        "A cat's purring is like a built-in relaxation soundtrack.",
        "Cats have a 'claw-some' sense of independence.",
        "Cats are expert ninja trainers, specializing in hiding in plain sight.",
        "If cats could write books, they'd all be tittled 'The Joy of knocking Things Over.",
        "Cats believe laptops were invented as warm napping spots.",
        "Cats view humans as their personal servants, available for petting on demand.",
        "Cats think gravity is just a suggestion."
    )
    return catFacts
}