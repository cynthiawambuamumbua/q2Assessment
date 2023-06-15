fun main(){
//    println(AncestralStories(29.0,"nice",10 ..12))
    var story=AncestralStories(10.89,"nice",19 ..25)
    story
    story.storyTeller(14.9,"boring",17 ..19)
    story.story(16.9,"nice",10 ..14)
    story.Translator(17.9,"enjoyable",18 ..20)
    var recipe=Recipe("meat","morning","stew","health")
    recipe
    recipe.recipe1("tomato","noon","boil","strong")
    recipe.recipe2("banana","evening","steam","strong")
    recipe.recipe3("njugu","morning","steam","weak")

}
// **Ancestral Stories:** In many African cultures,
//  the art of storytelling is passed
//  down from generation to generation. Imagine you're
// #creating an application that
// records these oral stories and translates them into different languages. The
// stories vary by length, moral lessons, and the age group they are intended for.
// Think about how you would model `Story`, `StoryTeller`, and `Translator`
// objects, and how inheritance might come into play if there are different types of
// stories or storytellers.

// input=length,moral-lessons,age-group
// output=story,story-teller,translator
// process=create a class;create the constructor,pass in the attributes,
//  create methods and pass in the conditions
class  AncestralStories(var length:Double,var moralLessons:String,var ageGroup:IntRange) {
    fun story(length: Double, moralLessons: String, ageGroup: IntRange) {
        println( "the story was $length,and it was given to children aged between $ageGroup, and it had different $moralLessons")
    }
    fun storyTeller(length: Double,moralLessons: String,ageGroup: IntRange){
        println("the story teller was aged  between $ageGroup ,and the story he gave was $length long, and $moralLessons were nice")
    }
    fun Translator(length: Double,moralLessons: String,ageGroup: IntRange){
        println("the translator was aged $ageGroup and the length of his interpretation was $length and the moral lessons from his interpretation were $moralLessons")

    }
}


// q2
// **African Cuisine:** You're creating a recipe app specifically for African cuisine.
// The app needs to handle recipes from different African countries, each with its
// unique ingredients, preparation time, cooking method, and nutritional
// information. Consider creating a `Recipe` class, and think about how you might
// create subclasses for different types of recipes (e.g., `MoroccanRecipe`,
// `EthiopianRecipe`, `NigerianRecipe`), each with their own unique properties and
// methods.

// input=recipes(ingredients,preparation time,cooking method,nutritional information)
// output=types of recipes
//  process=create a class Recipe,pass in the attributes,create methods and their subclasses

class Recipe(var ingredients:String,var preparationTime:String,var cookingMethod:String,var nutrtionalInformation:String){
    fun recipe(ingredients: String,preparationTime: String,cookingMethod: String,nutrtionalInformation: String){
        var recipe1=Recipe("meat","noon","boil","healthy")
        var recipe2=Recipe("tomato","morning","stew","healthier")
        var recipe3=Recipe("flour","evening","cook","strong")
        var recipes= listOf(recipe1,recipe2,recipe3)
        println(recipes)
    }
    fun recipe1(ingredients: String,preparationTime: String,cookingMethod: String,nutrtionalInformation: String){
        println("the moroccanRecipe was cooked using $ingredients,prepared at $preparationTime,using $cookingMethod and the nutritiona;l information is $nutrtionalInformation")

    }
    fun recipe2(ingredients: String,preparationTime: String,cookingMethod: String,nutrtionalInformation: String){
        println("the EthiopianRecipe was cooked using $ingredients,prepared at $preparationTime,using $cookingMethod and the nutritiona;l information is $nutrtionalInformation")

    }
    fun recipe3(ingredients: String,preparationTime: String,nutrtionalInformation: String,cookingMethod: String){
        println("the NigerianRecipe was cooked using $ingredients,prepared at $preparationTime,using $cookingMethod and the nutritiona;l information is $nutrtionalInformation")

    }
}
