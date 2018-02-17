package com.hainet.spring.core.sample;

import org.junit.Test;
import org.springframework.util.StringUtils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class StringUtilsTest {

    @Test
    public void isEmptyTest() {
        // True
        assertThat(StringUtils.isEmpty(""), is(true));
        assertThat(StringUtils.isEmpty(null), is(true));

        // False
        assertThat(StringUtils.isEmpty("It is not empty."), is(false));
    }

    @Test
    public void hasLengthTest() {
        // True
        assertThat(StringUtils.hasLength("It has length."), is(true));
        assertThat(StringUtils.hasLength(" "), is(true));

        // False
        assertThat(StringUtils.hasLength(""), is(false));
        assertThat(StringUtils.hasLength(null), is(false));
    }

    @Test
    public void hasTextTest() {
        // True
        assertThat(StringUtils.hasText("It has text"), is(true));

        // False
        assertThat(StringUtils.hasText(""), is(false));
        assertThat(StringUtils.hasText(" "), is(false));
        assertThat(StringUtils.hasText(null), is(false));
    }

    @Test
    public void containsWhitespaceTest() {
        // True
        assertThat(StringUtils.containsWhitespace(" "), is(true));

        // False
        assertThat(StringUtils.containsWhitespace(""), is(false));
        assertThat(StringUtils.containsWhitespace(null), is(false));
    }

    @Test
    public void trimWhiteSpaceTest() {
        assertThat(StringUtils.trimWhitespace(""), is(""));
        assertThat(StringUtils.trimWhitespace(" "), is(""));
        assertThat(StringUtils.trimWhitespace(" start"), is("start"));
        assertThat(StringUtils.trimWhitespace("end "), is("end"));
        assertThat(StringUtils.trimWhitespace(" both "), is("both"));
        assertThat(StringUtils.trimWhitespace("foo bar"), is("foo bar"));
        assertThat(StringUtils.trimWhitespace(null), is(nullValue()));
    }

    @Test
    public void trimAllWhiteSpaceTest() {
        assertThat(StringUtils.trimAllWhitespace(""), is(""));
        assertThat(StringUtils.trimAllWhitespace(" "), is(""));
        assertThat(StringUtils.trimAllWhitespace(" start"), is("start"));
        assertThat(StringUtils.trimAllWhitespace("end "), is("end"));
        assertThat(StringUtils.trimAllWhitespace(" both "), is("both"));
        assertThat(StringUtils.trimAllWhitespace("foo bar"), is("foobar"));
        assertThat(StringUtils.trimAllWhitespace(null), is(nullValue()));
    }

    @Test
    public void trimLeadingWhitespaceTest() {
        assertThat(StringUtils.trimLeadingWhitespace(""), is(""));
        assertThat(StringUtils.trimLeadingWhitespace(" "), is(""));
        assertThat(StringUtils.trimLeadingWhitespace(" start"), is("start"));
        assertThat(StringUtils.trimLeadingWhitespace("end "), is("end "));
        assertThat(StringUtils.trimLeadingWhitespace(" both "), is("both "));
        assertThat(StringUtils.trimLeadingWhitespace("foo bar"), is("foo bar"));
        assertThat(StringUtils.trimLeadingWhitespace(null), is(nullValue()));
    }

    @Test
    public void trimTrailingWhitespaceTest() {
        assertThat(StringUtils.trimTrailingWhitespace(""), is(""));
        assertThat(StringUtils.trimTrailingWhitespace(" "), is(""));
        assertThat(StringUtils.trimTrailingWhitespace(" start"), is(" start"));
        assertThat(StringUtils.trimTrailingWhitespace("end "), is("end"));
        assertThat(StringUtils.trimTrailingWhitespace(" both "), is(" both"));
        assertThat(StringUtils.trimTrailingWhitespace("foo bar"), is("foo bar"));
        assertThat(StringUtils.trimTrailingWhitespace(null), is(nullValue()));
    }

    @Test
    public void startsWithIgnoreCaseTest() {
        // True
        assertThat(StringUtils.startsWithIgnoreCase("Starts with ignore case.", "starts"), is(true));
        assertThat(StringUtils.startsWithIgnoreCase("Starts with ignore case.", "STARTS"), is(true));
        assertThat(StringUtils.startsWithIgnoreCase("It contains white space.", "It "), is(true));

        // False
        assertThat(StringUtils.startsWithIgnoreCase("12345", "1234567890"), is(false));
        assertThat(StringUtils.startsWithIgnoreCase(null, "null"), is(false));
        assertThat(StringUtils.startsWithIgnoreCase("null", null), is(false));
        assertThat(StringUtils.startsWithIgnoreCase(null, null), is(false));
    }

    @Test
    public void endsWithIgnoreCaseTest() {
        // True
        assertThat(StringUtils.endsWithIgnoreCase("Ends with ignore case.", "case."), is(true));
        assertThat(StringUtils.endsWithIgnoreCase("Ends with ignore case.", "CASE."), is(true));
        assertThat(StringUtils.endsWithIgnoreCase("It contains white space.", " space."), is(true));

        // False
        assertThat(StringUtils.endsWithIgnoreCase("54321", "0987654321"), is(false));
        assertThat(StringUtils.endsWithIgnoreCase(null, "null"), is(false));
        assertThat(StringUtils.endsWithIgnoreCase("null", null), is(false));
        assertThat(StringUtils.endsWithIgnoreCase(null, null), is(false));
    }
}
