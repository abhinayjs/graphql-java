package com.graphqljava.scalars;

import graphql.language.StringValue;
import graphql.schema.*;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateTimeScalarType extends GraphQLScalarType {

    public DateTimeScalarType() {
        super("DateTime", "Date time scalar", new Coercing() {
            @Override
            public Object serialize(Object dataFetcherResult) throws CoercingSerializeException {
                DateFormat formattedDate = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
                return formattedDate.format(new Date(dataFetcherResult.toString()));
            }

            @Override
            public Object parseValue(Object input) throws CoercingParseValueException {
                return serialize(input);
            }

            @Override
            public Object parseLiteral(Object input) throws CoercingParseLiteralException {
                if (input instanceof StringValue) {
                    return input.toString();
                } else {
                    return null;
                }
            }
        });
    }
}
