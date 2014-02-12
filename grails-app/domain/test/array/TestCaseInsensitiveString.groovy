package test.array

import net.kaleidos.hibernate.usertype.CaseInsensitiveStringArrayType

class TestCaseInsensitiveString {

    String[] caseInsensitiveStringArray

    static mapping = {
        caseInsensitiveStringArray type: CaseInsensitiveStringArrayType
    }
}
