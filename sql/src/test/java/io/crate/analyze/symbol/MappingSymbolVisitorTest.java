/*
 * Licensed to Crate under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.  Crate licenses this file
 * to you under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.  You may
 * obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * However, if you have executed another commercial license agreement
 * with Crate these terms will supersede the license and you may use the
 * software solely pursuant to the terms of the relevant commercial
 * agreement.
 */

package io.crate.analyze.symbol;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MappingSymbolVisitorTest {

    @Test
    public void testProcess() throws Exception {
        Symbol f = Literal.BOOLEAN_FALSE;
        Symbol t = Literal.BOOLEAN_TRUE;
        Symbol one = Literal.of(1);

        Map<Symbol, ? extends Symbol> fieldMap = ImmutableMap.of(f, t);

        assertThat(MappingSymbolVisitor.inPlace().process(f, fieldMap), is(t));
        assertThat(MappingSymbolVisitor.inPlace().process(one, fieldMap), is(one));
    }
}
