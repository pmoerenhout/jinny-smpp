package com.jinny.smpp.charset;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/**
 * The <b>CharsetProvider</b> class is a Charset Provider implementation.
 *
 * @author Pim Moerenhout
 * @since 2014-08-20
 */
public class CharsetProvider extends java.nio.charset.spi.CharsetProvider {

  static Map<String, Charset> name2charset;
  static Collection<Charset> charsets;

  /**
   * Retrieves a charset for the given charset name. </p>
   *
   * @param charsetName The name of the requested charset; may be either a canonical name or an alias
   * @return A charset object for the named charset, or <tt>null</tt> if the named charset is not supported by this
   * provider
   */
  @Override
  public Charset charsetForName(String charsetName) {
    if (name2charset == null) {
      init();
    }

    // get charset instance for given name (case insensitive)
    Charset c = name2charset.get(charsetName.toUpperCase(Locale.US));
    if (c != null) {
      try {
        return c.getClass().newInstance();
      }
      catch (Exception ignore) {
        // if we can't create an instance, we don't
      }
    }
    return null;
  }

  /**
   * Creates an iterator that iterates over the charsets supported by this provider.  This method is used in the
   * implementation of the {@link java.nio.charset.Charset#availableCharsets Charset.availableCharsets} method. </p>
   *
   * @return The new iterator
   */
  @Override
  public Iterator charsets() {
    if (charsets == null) {
      init();
    }

    return charsets.iterator();
  }

  /**
   * Initializes this charset provider's data.
   */
  void init() {
    // prepare supported charsets
    Charset[] cs = new Charset[]{ new SmppJinnyCharset() };

    // initialize charset collection
    charsets = Collections.unmodifiableCollection(Arrays.asList(cs));

    // initialize name to charset map
    Map n2c = new HashMap();
    for (int i = 0; i < cs.length; i++) {
      Charset c = cs[i];
      n2c.put(c.name().toUpperCase(Locale.US), c);
      for (Iterator a = c.aliases().iterator(); a.hasNext(); ) {
        n2c.put(((String) a.next()).toUpperCase(Locale.US), c);
      }
    }
    name2charset = n2c;
  }

}