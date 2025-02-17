/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.select.Select;
import org.junit.jupiter.api.Test;

/**
 *
 * @author tw
 */
public class ColumnTest {

    @Test
    public void testCheckNonFinalClass() {
        Column myColumn = new Column(null, "myColumn") {
            @Override
            public String toString() {
                return "anonymous class";
            }

        };
        assertEquals("anonymous class", myColumn.toString());
    }

    @Test
    void columnAnyTest() throws JSQLParserException {
        String dql = "SELECT * FROM MY_TABLE1 WHERE any c1 = 'v'";

        Select select = (Select) CCJSqlParserUtil.parse(dql);
        assertEquals("SELECT * FROM MY_TABLE1 WHERE ANY c1 = 'v'", select.toString());
    }
}
