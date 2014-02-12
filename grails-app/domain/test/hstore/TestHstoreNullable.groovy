package test.hstore

import net.kaleidos.hibernate.postgresql.hstore.Hstore
import net.kaleidos.hibernate.usertype.HstoreType
import net.kaleidos.hibernate.postgresql.hstore.HstoreDomainType

class TestHstoreNullable {
    String name

    @Hstore
    Map testAttributes = new HstoreDomainType([:])

    static constraints = {
        //testAttributes nullable: true
    }
    static mapping = {
        testAttributes type:HstoreType
    }
}


