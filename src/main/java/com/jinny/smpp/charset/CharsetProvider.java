/*
 *  Copyright © 2005-2012 Amichai Rothman
 *
 *  This file is part of JCharset - the Java Charset package.
 *
 *  JCharset is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  JCharset is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with JCharset.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  For additional info see http://www.freeutils.net/source/jcharset/
 */

package com.jinny.smpp.charset;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import com.sun.istack.internal.Nullable;

/**
 * The <b>CharsetProvider</b> class is a Charset Provider implementation.
 *
 * @author Pim Moerenhout
 * @since 2014-08-20
 */
public class CharsetProvider extends java.nio.charset.spi.CharsetProvider {

  static Map name2charset;
  static Collection charsets;

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
    Charset c = (Charset) name2charset.get(charsetName.toUpperCase(Locale.US));
    if (c != null) {
      try {
        return (Charset) c.getClass().newInstance();
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
    Charset[] cs = new Charset[]{
        new SmppJinny() };

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
