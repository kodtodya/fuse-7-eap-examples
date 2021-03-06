/*
 * #%L
 * Wildfly Camel :: Example :: Camel JMS
 * %%
 * Copyright (C) 2013 - 2014 RedHat
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.kodtodya.practice.jms;

import java.io.InputStream;
import java.util.Random;

import javax.inject.Named;

import org.apache.camel.CamelContext;

@Named
public class OrderGenerator {

    public static final String[] COUNTRIES = {"UK", "US", "Other"};

    private int count = 1;
    private Random random = new Random();

    public InputStream generateOrder(CamelContext camelContext) {
        String countryCode = COUNTRIES[random.nextInt(3)].toLowerCase();
        String name = String.format("/%s-order.xml", countryCode);

        return camelContext.getClassResolver().loadResourceAsStream(name);
    }

    public String generateFileName() {
        return "order" + count++ + ".xml";
    }

}
