package net.kaleidos.hibernate.array

import grails.plugin.spock.*
import spock.lang.*

import test.array.TestEnum
import test.array.TestInteger
import test.array.TestLong
import test.array.TestString
import test.array.TestCaseInsensitiveString

class PostgresqlArraysDomainIntegrationSpec extends IntegrationSpec {

    @Unroll
    void 'save a domain class with an integer array value'() {
        setup:
            def testInt = new TestInteger(integerNumbers:numbers)

        when:
            testInt.save()

        then:
            testInt.hasErrors() == false
            testInt.integerNumbers.length == numbers.size()

        where:
            numbers << [ [], [5], [3, -1], [-9, 4, -123, 0] ]
    }

    @Unroll
    void 'save a domain class with a long array value'() {
        setup:
            def testLong = new TestLong(longNumbers:numbers)

        when:
            testLong.save()

        then:
            testLong.hasErrors() == false
            testLong.longNumbers.length == numbers.size()

        where:
            numbers << [ [], [5L], [3L, -1L], [-9L, 4L, -123L, 0L] ]
    }

    @Unroll
    void 'save a domain class with a string array value'() {
        setup:
            def testString = new TestString(stringArray:strings)

        when:
            testString.save()

        then:
            testString.hasErrors() == false
            testString.stringArray.length == strings.size()

        where:
            strings << [ [], ["string 1"], ["string 1", "string 2"], ["string 1", "string 2", "string 3"] ]
    }

    @Unroll
    void 'save a domain class with an enum array value'() {
        setup:
            def testEnum = new TestEnum(days: days)

        when:
            testEnum.save()

        then:
            testEnum.hasErrors() == false
            testEnum.days.length == days.size()

        where:
            days << [ [], [TestEnum.Day.MONDAY], [TestEnum.Day.SUNDAY, TestEnum.Day.SATURDAY], [TestEnum.Day.WEDNESDAY, TestEnum.Day.THURSDAY, TestEnum.Day.TUESDAY] ]
    }
@spock.lang.IgnoreRest
    @Unroll
    void 'save a domain class with a case insensitive string array value'() {
        setup:
            def testCaseInsensitiveString = new TestCaseInsensitiveString(caseInsensitiveStringArray:strings)

        when:
            testCaseInsensitiveString.save()

        then:
            testCaseInsensitiveString.hasErrors() == false
            testCaseInsensitiveString.caseInsensitiveStringArray.length == strings.size()

        where:
            strings << [ [], ["StrIng 1"], ["sTriNG 1", "strIng 2"], ["STring 1", "stRing 2", "stRiNg 3"] ]
    }

}
