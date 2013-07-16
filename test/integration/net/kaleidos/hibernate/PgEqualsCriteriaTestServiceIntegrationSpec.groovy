package net.kaleidos.hibernate

import org.hibernate.HibernateException;

import grails.plugin.spock.*
import spock.lang.*

import test.criteria.User
import test.criteria.Like

class PgEqualsCriteriaTestServiceIntegrationSpec extends IntegrationSpec {

    def pgEqualsCriteriaTestService

    @Unroll
    void 'check equals #number in an array of integers'() {
        setup:
            new Like(favoriteNumbers:[3, 7, 20]).save()
            new Like(favoriteNumbers:[17]).save()
            new Like(favoriteNumbers:[3, 4, 20]).save()
            new Like(favoriteNumbers:[9, 4, 20]).save()
            new Like(favoriteNumbers:[]).save()

        when:
            def result = pgEqualsCriteriaTestService.equalsIntegerArray(number)

        then:
            result.size() == resultSize

        where:
            number     | resultSize
              3        |     0
              17       |     1
              [3,7,20] |     1
              [3,4,20] |     1
              [4,20,3] |     0
              []       |     1
    }

    @Unroll
    void 'check equals #number in an array of longs'() {
        setup:
            new Like(favoriteLongNumbers:[1L, 23L, 34L]).save()
            new Like(favoriteLongNumbers:[7L]).save()
            new Like(favoriteLongNumbers:[-9L, 16L, 7L]).save()
            new Like(favoriteLongNumbers:[1L]).save()
        when:
            def result = pgEqualsCriteriaTestService.equalsLongArray(number)

        then:
            result.size() == resultSize

        where:
                   number      | resultSize
                      1L       |     0
                      7L       |     1
                [-9L, 16L, 7L] |     1
                [16L, -9L, 7L] |     0
                      [1L]     |     3
                      []       |     0
    }

    // @Unroll
    // void 'search #movie in an array of strings'() {
    //     setup:
    //         new Like(favoriteMovies:["The Matrix", "The Lord of the Rings"]).save()
    //         new Like(favoriteMovies:["Spiderman", "Blade Runner", "Starwars"]).save()
    //         new Like(favoriteMovies:["Romeo & Juliet", "Casablanca", "Starwars"]).save()
    //         new Like(favoriteMovies:["Romeo & Juliet", "Blade Runner", "The Lord of the Rings"]).save()

    //     when:
    //         def result = pgEqualsCriteriaTestService.overlapsStringArray(movie)

    //     then:
    //         result.size() == resultSize

    //     where:
    //         movie                                       | resultSize
    //         "The Matrix"                                |     1
    //         "The Lord of the Rings"                     |     2
    //         "Blade Runner"                              |     2
    //         "Starwars"                                  |     2
    //         "The Usual Suspects"                        |     0
    //         ["Starwars", "Romeo & Juliet"]              |     3
    //         ["The Lord of the Rings"]                   |     2
    //         []                                          |     0
    // }

    // void 'search in an array of strings with join with another domain class'() {
    //     setup:
    //         def user1 = new User(name:'John', like: new Like(favoriteMovies:["The Matrix", "The Lord of the Rings"])).save()
    //         def user2 = new User(name:'Peter', like: new Like(favoriteMovies:["Spiderman", "Blade Runner", "Starwars"])).save()
    //         def user3 = new User(name:'Mary', like: new Like(favoriteMovies:["Romeo & Juliet", "Casablanca", "Starwars"])).save()
    //         def user4 = new User(name:'Jonhny', like: new Like(favoriteMovies:["Romeo & Juliet", "Blade Runner", "The Lord of the Rings"])).save()

    //     when:
    //         def result = pgEqualsCriteriaTestService.overlapsStringWithJoin(movie)

    //     then:
    //         result.size() == 3
    //         result.contains(user2) == true
    //         result.contains(user3) == true
    //         result.contains(user4) == true

    //     where:
    //         movie = ["Starwars", "Romeo & Juliet"]
    // }

    // void 'search in an array of strings with join with another domain class and or statement'() {
    //     setup:
    //         def user1 = new User(name:'John', like: new Like(favoriteNumbers:[3, 7], favoriteMovies:["The Matrix", "The Lord of the Rings"])).save()
    //         def user2 = new User(name:'Peter', like: new Like(favoriteNumbers:[5, 17, 9, 6], favoriteMovies:["Spiderman", "Blade Runner", "Starwars"])).save()
    //         def user3 = new User(name:'Mary', like: new Like(favoriteNumbers:[3, 4], favoriteMovies:["Romeo & Juliet", "Casablanca", "Starwars"])).save()
    //         def user4 = new User(name:'Jonhny', like: new Like(favoriteNumbers:[9, 4], favoriteMovies:["Romeo & Juliet", "Blade Runner", "The Lord of the Rings"])).save()

    //     when:
    //         def result = pgEqualsCriteriaTestService.overlapsStringOrIntergetWithJoin(movie, number)

    //     then:
    //         result.size() == 2
    //         result.contains(user2) == true
    //         result.contains(user4) == true

    //     where:
    //         movie = ["Starwars", "Romeo & Juliet"]
    //         number = [9]
    // }

    // @Unroll
    // void 'search a invalid list inside the array of integers'() {
    //     when:
    //         def result = pgEqualsCriteriaTestService.overlapsIntegerArray(number)

    //     then:
    //         thrown(HibernateException)

    //     where:
    //         number << [["Test"], [1, "Test"], [1L], [1, 1L]]
    // }

    // @Unroll
    // void 'search a invalid list inside the array of long'() {
    //     when:
    //         def result = pgEqualsCriteriaTestService.overlapsLongArray(number)

    //     then:
    //         thrown(HibernateException)

    //     where:
    //         number << [["Test"], [1L, "Test"], [1], [1L, 1]]
    // }

    // @Unroll
    // void 'search a invalid list inside the array of string'() {
    //     when:
    //         def result = pgEqualsCriteriaTestService.overlapsStringArray(movie)

    //     then:
    //         thrown(HibernateException)

    //     where:
    //         movie << [[1], ["Test", 1], [1L], ["Test", 1L]]
    // }

}