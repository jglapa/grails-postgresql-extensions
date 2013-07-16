package test.criteria

class PgEqualsCriteriaTestService {
    static transactional = false

    /**
     * Search "equals" integer in array
     */
    public List<Like> equalsIntegerArray(Integer number) {
        def result = Like.withCriteria {
            pgEquals 'favoriteNumbers', number
        }

        return result
    }

    /**
     * Search "equals" with n integers in array
     */
    public List<Like> equalsIntegerArray(List<Integer> numbers) {
        def result = Like.withCriteria {
            pgEquals 'favoriteNumbers', numbers
        }

        return result
    }

    /**
     * Search "equals" with long in array
     */
    public List<Like> equalsLongArray(Long number) {
        def result = Like.withCriteria {
            pgEquals 'favoriteLongNumbers', number
        }

        return result
    }

    /**
     * Search "equals" with n longs in array
     */
    public List<Like> equalsLongArray(List<Long> numbers) {
        def result = Like.withCriteria {
            pgEquals 'favoriteLongNumbers', numbers
        }

        return result
    }

    // /**
    //  * Search overlaps "equals" with string in array
    //  */
    // public List<Like> overlapsStringArray(String movie) {
    //     def result = Like.withCriteria {
    //         pgEquals 'favoriteMovies', movie
    //     }

    //     return result
    // }

    // /**
    //  * Search overlaps "equals" with n strings in array
    //  */
    // public List<Like> overlapsStringArray(List<String> movie) {
    //     def result = Like.withCriteria {
    //         pgEquals 'favoriteMovies', movie
    //     }

    //     return result
    // }

    // /**
    //  * Search overlaps with a join
    //  */
    // public List<User> overlapsStringWithJoin(List<String> movies) {
    //     def results = User.withCriteria {
    //         like {
    //             pgEquals 'favoriteMovies', movies
    //         }
    //     }

    //     return results
    // }

    // /**
    //  * Search overlaps with a join and an 'or'
    //  */
    // public List<User> overlapsStringOrIntergetWithJoin(List<String> movies, List<Integer> numbers) {
    //     def results = User.withCriteria {
    //         like {
    //             and {
    //                 pgEquals 'favoriteMovies', movies
    //                 pgEquals 'favoriteNumbers', numbers
    //             }
    //         }
    //     }

    //     return results
    // }
}