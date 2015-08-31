package com.jinny.smpp.charset;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class SmppJinnyCharsetTest {

  final String CHARSET_NAME = "X-SMPP-JINNY";

  // http://grepcode.com/file_/repository.grepcode.com/java/root/jdk/openjdk/7u40-b43/sun/nio/cs/ISO_8859_2.java/?v=source

  Charset charset;
  CharsetDecoder decoder;
  CharsetEncoder encoder;

  @Before
  public void setUp() throws Exception {
    charset = Charset.forName(CHARSET_NAME);
    decoder = charset.newDecoder();
    encoder = charset.newEncoder();
  }

  @Test
  public void testName() throws Exception {
    assertEquals(CHARSET_NAME, charset.displayName());
  }

  @Test
  public void testAliases() throws Exception {
    Set<String> aliases = new HashSet<String>();
    aliases.add("x-smpp-jinny");
    aliases.add("smpp-jinny");
    aliases.add("smppjinny");
    assertEquals(aliases, charset.aliases());
  }

  @Test
  public void testEncode() throws Exception {
    assertTrue(charset.canEncode());
  }

  @Test
  public void testEncoding() throws Exception {

    System.out.println("Φ is unicode " + String.format("%04X", (short) 'Φ'));
    System.out.println("€ is unicode " + String.format("%04X", (short) '€'));
    System.out.println("£ is unicode " + String.format("%04X", (short) '£'));
    System.out.println("Ñ is unicode " + String.format("%04X", (short) 'Ñ'));
    System.out.println("Ø is unicode " + String.format("%04X", (short) 'Ø'));
    System.out.println("Æ is unicode " + String.format("%04X", (short) 'Æ'));
    System.out.println("Å is unicode " + String.format("%04X", (short) 'Å'));
    System.out.println("ø is unicode " + String.format("%04X", (short) 'ø'));
    System.out.println("Õ is unicode " + String.format("%04X", (short) 'Õ'));
    System.out.println("ø is unicode " + String.format("%04X", (short) 'ø'));
    System.out
        .println("Δ is unicode " + String.format("%04X", (short) 'Δ') + " " + String.format("%02X 16", (byte) 16));
    System.out
        .println("Φ is unicode " + String.format("%04X", (short) 'Φ') + " " + String.format("%02X 18", (byte) 18));
    System.out
        .println("Γ is unicode " + String.format("%04X", (short) 'Γ') + " " + String.format("%02X 19", (byte) 19));
    System.out
        .println("Λ is unicode " + String.format("%04X", (short) 'Λ') + " " + String.format("%02X 20", (byte) 20));
    System.out
        .println("Ω is unicode " + String.format("%04X", (short) 'Ω') + " " + String.format("%02X 21", (byte) 21));
    System.out
        .println("Π is unicode " + String.format("%04X", (short) 'Π') + " " + String.format("%02X 22", (byte) 22));
    System.out.println("Ψ is unicode " + String.format("%04X", (short) 'Ψ') + " " + String.format("%02X", (byte) 23));
    System.out.println("Σ is unicode " + String.format("%04X", (short) 'Σ') + " " + String.format("%02X", (byte) 24));
    System.out.println("θ is unicode " + String.format("%04X", (short) 'θ') + " " + String.format("%02X", (byte) 25));
    System.out.println("Ξ is unicode " + String.format("%04X", (short) 'Ξ') + " " + String.format("%02X", (byte) 26));
    System.out.println("€ is unicode " + String.format("%04X", (short) '€') + " " + String.format("%02X", (byte) 31));
    System.out.println("' is unicode " + String.format("%04X", (short) '\'') + " " + String.format("%02X", (byte) 39));
    System.out.println("_ is unicode " + String.format("%04X", (short) '_') + " " + String.format("%02X", (byte) 131));
    System.out.println(
        "\u00A2 is unicode " + String.format("%04X", (short) '\u00A2') + " " + String.format("%02X", (byte) 162));
    System.out.println("£ is unicode " + String.format("%04X", (short) '£') + " " + String.format("%02X", (byte) 175));
    System.out.println("± is unicode " + String.format("%04X", (short) '±') + " " + String.format("%02X", (byte) 177));
    System.out
        .println("ç is unicode " + String.format("%04X", (short) 'ç') + " " + String.format("%02X 180", (byte) 180));
    System.out.println("Ñ is unicode " + String.format("%04X", (short) 'Ñ') + " " + String.format("%02X", (byte) 182));
    System.out.println("ñ is unicode " + String.format("%04X", (short) 'ñ') + " " + String.format("%02X", (byte) 183));
    System.out
        .println("¡ is unicode " + String.format("%04X", (short) '¡') + " " + String.format("%02X 184", (byte) 184));
    System.out
        .println("¤ is unicode " + String.format("%04X", (short) '¤') + " " + String.format("%02X 186", (byte) 186));
    System.out.println("» is unicode " + String.format("%04X", (short) '»') + " " + String.format("%02X", (byte) 187));
    System.out
        .println("¥ is unicode " + String.format("%04X", (short) '¥') + " " + String.format("%02X 188", (byte) 188));
    System.out.println("§ is unicode " + String.format("%04X", (short) '§') + " " + String.format("%02X", (byte) 189));
    System.out
        .println("¾ is unicode " + String.format("%04X", (short) '¾') + " " + String.format("%02X 190", (byte) 190));
    System.out.println("¿ is unicode " + String.format("%04X", (short) '¿') + " " + String.format("%02X", (byte) 191));
    System.out.println("É is unicode " + String.format("%04X", (short) 'É') + " " + String.format("%02X", (byte) 197));

    System.out.println("Ç is unicode " + String.format("%04X", (short) 'Ç') + " " + String.format("%02X", (byte) 199));
    System.out
        .println("À is unicode " + String.format("%04X", (short) 'À') + " " + String.format("%02X 200", (byte) 200));
    System.out.println("è is unicode " + String.format("%04X", (short) 'è') + " " + String.format("%02X", (byte) 201));
    System.out.println("ò is unicode " + String.format("%04X", (short) 'ò') + " " + String.format("%02X", (byte) 202));
    System.out.println("ù is unicode " + String.format("%04X", (short) 'ù') + " " + String.format("%02X", (byte) 203));
    System.out.println("ä is unicode " + String.format("%04X", (short) 'ä') + " " + String.format("%02X", (byte) 204));
    System.out.println("ö is unicode " + String.format("%04X", (short) 'ö') + " " + String.format("%02X", (byte) 206));
    System.out.println("ü is unicode " + String.format("%04X", (short) 'ü') + " " + String.format("%02X", (byte) 207));
    System.out.println("Å is unicode " + String.format("%04X", (short) 'Å') + " " + String.format("%02X", (byte) 208));
    System.out
        .println("Ø is unicode " + String.format("%04X", (short) 'Ø') + " " + String.format("%02X 210", (byte) 210));
    System.out
        .println("Æ is unicode " + String.format("%04X", (short) 'Æ') + " " + String.format("%02X 211", (byte) 211));
    System.out
        .println("Å is unicode " + String.format("%04X", (short) 'Å') + " " + String.format("%02X 212", (byte) 212));
    System.out
        .println("æ is unicode " + String.format("%04X", (short) 'æ') + " " + String.format("%02X 215", (byte) 215));
    System.out
        .println("Ä is unicode " + String.format("%04X", (short) 'Ä') + " " + String.format("%02X 216", (byte) 216));
    System.out
        .println("ì is unicode " + String.format("%04X", (short) 'ì') + " " + String.format("%02X 217", (byte) 217));
    System.out
        .println("Ö is unicode " + String.format("%04X", (short) 'Ö') + " " + String.format("%02X 218", (byte) 218));
    System.out
        .println("Û is unicode " + String.format("%04X", (short) 'Û') + " " + String.format("%02X 219", (byte) 219));
    System.out
        .println("É is unicode " + String.format("%04X", (short) 'É') + " " + String.format("%02X 220", (byte) 220));
    System.out.println("Þ is unicode " + String.format("%04X", (short) 'Þ') + " " + String.format("%02X", (byte) 222));
    System.out.println("à is unicode " + String.format("%04X", (short) 'à') + " " + String.format("%02X", (byte) 224));
    System.out
        .println("ä is unicode " + String.format("%04X", (short) 'ä') + " " + String.format("%02X 228", (byte) 228));
    System.out.println("æ is unicode " + String.format("%04X", (short) 'æ') + " " + String.format("%02X", (byte) 230));
    System.out
        .println("è is unicode " + String.format("%04X", (short) 'è') + " " + String.format("%02X 232", (byte) 232));
    System.out.println("ê is unicode " + String.format("%04X", (short) 'ê') + " " + String.format("%02X", (byte) 234));
    System.out
        .println("ì is unicode " + String.format("%04X", (short) 'ì') + " " + String.format("%02X 236", (byte) 236));
    System.out.println("ï is unicode " + String.format("%04X", (short) 'ï') + " " + String.format("%02X", (byte) 239));
    System.out
        .println("Ð is unicode " + String.format("%04X", (short) 'Ð') + " " + String.format("%02X 240", (byte) 240));
    System.out
        .println("ñ is unicode " + String.format("%04X", (short) 'ñ') + " " + String.format("%02X 241", (byte) 241));
    System.out.println("ò is unicode " + String.format("%04X", (short) 'ò') + " " + String.format("%02X", (byte) 242));
    System.out
        .println("ö is unicode " + String.format("%04X", (short) 'ö') + " " + String.format("%02X 246", (byte) 246));
    System.out
        .println("ø is unicode " + String.format("%04X", (short) 'ø') + " " + String.format("%02X 248", (byte) 248));
    System.out.println("ù is unicode " + String.format("%04X", (short) 'ù') + " " + String.format("%02X", (byte) 249));
    System.out.println("ú is unicode " + String.format("%04X", (short) 'ú') + " " + String.format("%02X", (byte) 250));
    System.out.println("û is unicode " + String.format("%04X", (short) 'û') + " " + String.format("%02X", (byte) 251));
    System.out.println("ü is unicode " + String.format("%04X", (short) 'ü') + " " + String.format("%02X", (byte) 252));
    System.out.println("ý is unicode " + String.format("%04X", (short) 'ý') + " " + String.format("%02X", (byte) 253));
    System.out.println("þ is unicode " + String.format("%04X", (short) 'þ') + " " + String.format("%02X", (byte) 254));
    System.out.println("ÿ is unicode " + String.format("%04X", (short) 'ÿ') + " " + String.format("%02X", (byte) 255));
    System.out.println("\" is unicode " + String.format("%04X", (short) '"') + " " + String.format("%02X", (byte) 34));

    assertArrayEquals(new byte[]{ 0 }, encode('\u0000'));
    assertArrayEquals(new byte[]{ 1 }, encode('\u0001'));
    assertArrayEquals(new byte[]{ 2 }, encode('\u0002'));
    assertArrayEquals(new byte[]{ 3 }, encode('\u0003'));
    assertArrayEquals(new byte[]{ 4 }, encode('\u0004'));
    assertArrayEquals(new byte[]{ 5 }, encode('\u0005'));
    assertArrayEquals(new byte[]{ 6 }, encode('\u0006'));
    assertArrayEquals(new byte[]{ 7 }, encode('\u0007'));
    assertArrayEquals(new byte[]{ 8 }, encode('\b'));
    assertArrayEquals(new byte[]{ 9 }, encode('\t'));
    assertArrayEquals(new byte[]{ 10 }, encode('\n'));
    assertArrayEquals(new byte[]{ 11 }, encode('\u000B'));
    assertArrayEquals(new byte[]{ 12 }, encode('\f'));
    assertArrayEquals(new byte[]{ 13 }, encode('\r'));
    assertArrayEquals(new byte[]{ 14 }, encode('\u000E'));
    assertArrayEquals(new byte[]{ 15 }, encode('\u000F'));
    assertArrayEquals(new byte[]{ 16 }, encode('Δ'));
    assertArrayEquals(new byte[]{ 17 }, encode('\u0011'));
    assertArrayEquals(new byte[]{ 18 }, encode('Φ'));
    assertArrayEquals(new byte[]{ 19 }, encode('Γ'));
    assertArrayEquals(new byte[]{ 20 }, encode('Λ'));
    assertArrayEquals(new byte[]{ 21 }, encode('Ω'));
    assertArrayEquals(new byte[]{ 22 }, encode('Π'));
    assertArrayEquals(new byte[]{ 23 }, encode('Ψ'));
    assertArrayEquals(new byte[]{ 24 }, encode('Σ'));
    assertArrayEquals(new byte[]{ 25 }, encode('θ'));
    assertArrayEquals(new byte[]{ 26 }, encode('Ξ'));
    assertArrayEquals(new byte[]{ 27 }, encode('\u001B'));
    assertArrayEquals(new byte[]{ 28 }, encode('\u001C'));
    assertArrayEquals(new byte[]{ 29 }, encode('\u001D'));
    assertArrayEquals(new byte[]{ 30 }, encode('\u001E'));
    assertArrayEquals(new byte[]{ 31 }, encode('€'));
    assertArrayEquals(new byte[]{ 32 }, encode(' '));
    assertArrayEquals(new byte[]{ 33 }, encode('!'));
    assertArrayEquals(new byte[]{ 34 }, encode('"'));
    assertArrayEquals(new byte[]{ 35 }, encode('#'));
    assertArrayEquals(new byte[]{ 36 }, encode('$'));
    assertArrayEquals(new byte[]{ 37 }, encode('%'));
    assertArrayEquals(new byte[]{ 38 }, encode('&'));
    assertArrayEquals(new byte[]{ 39 }, encode('\''));
    assertArrayEquals(new byte[]{ 40 }, encode('('));
    assertArrayEquals(new byte[]{ 41 }, encode(')'));
    assertArrayEquals(new byte[]{ 42 }, encode('*'));
    assertArrayEquals(new byte[]{ 43 }, encode('+'));
    assertArrayEquals(new byte[]{ 44 }, encode(','));
    assertArrayEquals(new byte[]{ 44 }, encode(','));
    assertArrayEquals(new byte[]{ 45 }, encode('-'));
    assertArrayEquals(new byte[]{ 46 }, encode('.'));
    assertArrayEquals(new byte[]{ (byte) 47 }, encode('/'));
    assertArrayEquals(new byte[]{ (byte) 48 }, encode('0'));
    assertArrayEquals(new byte[]{ (byte) 49 }, encode('1'));
    assertArrayEquals(new byte[]{ (byte) 50 }, encode('2'));
    assertArrayEquals(new byte[]{ (byte) 51 }, encode('3'));
    assertArrayEquals(new byte[]{ (byte) 56 }, encode('8'));
    assertArrayEquals(new byte[]{ (byte) 57 }, encode('9'));
    assertArrayEquals(new byte[]{ (byte) 58 }, encode(':'));
    assertArrayEquals(new byte[]{ (byte) 59 }, encode(';'));
    assertArrayEquals(new byte[]{ (byte) 60 }, encode('<'));
    assertArrayEquals(new byte[]{ (byte) 61 }, encode('='));
    assertArrayEquals(new byte[]{ (byte) 62 }, encode('>'));
    assertArrayEquals(new byte[]{ (byte) 63 }, encode('?'));
    assertArrayEquals(new byte[]{ (byte) 64 }, encode('@'));
    assertArrayEquals(new byte[]{ (byte) 65 }, encode('A'));
    assertArrayEquals(new byte[]{ (byte) 66 }, encode('B'));
    assertArrayEquals(new byte[]{ (byte) 67 }, encode('C'));
    assertArrayEquals(new byte[]{ (byte) 88 }, encode('X'));
    assertArrayEquals(new byte[]{ (byte) 89 }, encode('Y'));
    assertArrayEquals(new byte[]{ (byte) 90 }, encode('Z'));
    assertArrayEquals(new byte[]{ (byte) 91 }, encode('['));
    assertArrayEquals(new byte[]{ (byte) 92 }, encode('\\'));
    assertArrayEquals(new byte[]{ (byte) 93 }, encode(']'));
    assertArrayEquals(new byte[]{ (byte) 94 }, encode('^'));
    assertArrayEquals(new byte[]{ (byte) 95 }, encode('_'));
    assertArrayEquals(new byte[]{ (byte) 96 }, encode('`'));
    assertArrayEquals(new byte[]{ (byte) 97 }, encode('a'));
    assertArrayEquals(new byte[]{ (byte) 98 }, encode('b'));
    assertArrayEquals(new byte[]{ (byte) 99 }, encode('c'));
    assertArrayEquals(new byte[]{ (byte) 120 }, encode('x'));
    assertArrayEquals(new byte[]{ (byte) 121 }, encode('y'));
    assertArrayEquals(new byte[]{ (byte) 122 }, encode('z'));
    assertArrayEquals(new byte[]{ (byte) 123 }, encode('{'));
    assertArrayEquals(new byte[]{ (byte) 124 }, encode('|'));
    assertArrayEquals(new byte[]{ (byte) 125 }, encode('}'));
    assertArrayEquals(new byte[]{ (byte) 126 }, encode('~'));
    assertArrayEquals(new byte[]{ (byte) 127 }, encode('\u007F'));
    assertArrayEquals(new byte[]{ (byte) 128 }, encode('\u0080'));
    assertArrayEquals(new byte[]{ (byte) 129 }, encode('\u0081'));
    assertArrayEquals(new byte[]{ (byte) 130 }, encode('\u0082'));
    assertArrayEquals(new byte[]{ (byte) 131 }, encode('\u0083'));
    assertArrayEquals(new byte[]{ (byte) 132 }, encode('\u0084'));
    assertArrayEquals(new byte[]{ (byte) 133 }, encode('\u0085'));
    assertArrayEquals(new byte[]{ (byte) 134 }, encode('\u0086'));
    assertArrayEquals(new byte[]{ (byte) 135 }, encode('\u0087'));
    assertArrayEquals(new byte[]{ (byte) 136 }, encode('\u0088'));
    assertArrayEquals(new byte[]{ (byte) 137 }, encode('\u0089'));
    assertArrayEquals(new byte[]{ (byte) 138 }, encode('\u008A'));
    assertArrayEquals(new byte[]{ (byte) 139 }, encode('\u008B'));
    assertArrayEquals(new byte[]{ (byte) 140 }, encode('\u008C'));
    assertArrayEquals(new byte[]{ (byte) 141 }, encode('\u008D'));
    assertArrayEquals(new byte[]{ (byte) 142 }, encode('\u008E'));
    assertArrayEquals(new byte[]{ (byte) 143 }, encode('\u008F'));
    assertArrayEquals(new byte[]{ (byte) 144 }, encode('\u0090'));
    assertArrayEquals(new byte[]{ (byte) 145 }, encode('\u0091'));
    assertArrayEquals(new byte[]{ (byte) 146 }, encode('\u0092'));
    assertArrayEquals(new byte[]{ (byte) 147 }, encode('\u0093'));
    assertArrayEquals(new byte[]{ (byte) 148 }, encode('\u0094'));
    assertArrayEquals(new byte[]{ (byte) 149 }, encode('\u0095'));
    assertArrayEquals(new byte[]{ (byte) 150 }, encode('\u0096'));
    assertArrayEquals(new byte[]{ (byte) 151 }, encode('\u0097'));
    assertArrayEquals(new byte[]{ (byte) 152 }, encode('\u0098'));
    assertArrayEquals(new byte[]{ (byte) 153 }, encode('\u0099'));
    assertArrayEquals(new byte[]{ (byte) 154 }, encode('\u009A'));
    assertArrayEquals(new byte[]{ (byte) 155 }, encode('\u009B'));
    assertArrayEquals(new byte[]{ (byte) 156 }, encode('\u009C'));
    assertArrayEquals(new byte[]{ (byte) 157 }, encode('\u009D'));
    assertArrayEquals(new byte[]{ (byte) 158 }, encode('\u009E'));
    assertArrayEquals(new byte[]{ (byte) 159 }, encode('\u009F'));
    assertArrayEquals(new byte[]{ (byte) 160 }, encode('\u00A0'));
    //assertArrayEquals(new byte[]{ (byte) 161 }, encode('\u00A1')); // See 184
    assertArrayEquals(new byte[]{ (byte) 162 }, encode('\u00A2'));
    //assertArrayEquals(new byte[]{ (byte) 163 }, encode('£')); // See 175
    //assertArrayEquals(new byte[]{ (byte) 164 }, encode('¤')); // see 186
    //assertArrayEquals(new byte[]{ (byte) 165 }, encode('¥'));
    assertArrayEquals(new byte[]{ (byte) 166 }, encode('\u00A6'));
    //assertArrayEquals(new byte[]{ (byte) 167 }, encode('\u00A7')); // See 189
    assertArrayEquals(new byte[]{ (byte) 168 }, encode('\u00A8'));
    assertArrayEquals(new byte[]{ (byte) 169 }, encode('\u00A9'));
    assertArrayEquals(new byte[]{ (byte) 170 }, encode('\u00AA'));
    assertArrayEquals(new byte[]{ (byte) 171 }, encode('\u00AB'));
    assertArrayEquals(new byte[]{ (byte) 172 }, encode('\u00AC'));
    assertArrayEquals(new byte[]{ (byte) 173 }, encode('\u00AD'));
    assertArrayEquals(new byte[]{ (byte) 174 }, encode('\u00AE'));
    assertArrayEquals(new byte[]{ (byte) 175 }, encode('£')); // See 167
    assertArrayEquals(new byte[]{ (byte) 176 }, encode('°'));
    assertArrayEquals(new byte[]{ (byte) 177 }, encode('±'));
    assertArrayEquals(new byte[]{ (byte) 178 }, encode('²'));
    assertArrayEquals(new byte[]{ (byte) 179 }, encode('³'));
    //assertArrayEquals(new byte[]{ (byte) 180 }, encode('ç')); // see 231 (0xE7)
    assertArrayEquals(new byte[]{ (byte) 181 }, encode('µ'));
    //assertArrayEquals(new byte[]{ (byte) 182 }, encode('Ñ')); // see 209
    //assertArrayEquals(new byte[]{ (byte) 183 }, encode('ñ')); // see 241
    assertArrayEquals(new byte[]{ (byte) 184 }, encode('¡'));
    //assertArrayEquals(new byte[]{ (byte) 185 }, encode('¿')); /see 191
    assertArrayEquals(new byte[]{ (byte) 186 }, encode('¤'));
    assertArrayEquals(new byte[]{ (byte) 187 }, encode('»'));
    //assertArrayEquals(new byte[]{ (byte) 188 }, encode('¥'));
    assertArrayEquals(new byte[]{ (byte) 189 }, encode('§'));
    assertArrayEquals(new byte[]{ (byte) 190 }, encode('¾'));
    assertArrayEquals(new byte[]{ (byte) 191 }, encode('¿'));
    //assertArrayEquals(new byte[]{ (byte) 192 }, encode('À')); // See 200
    assertArrayEquals(new byte[]{ (byte) 193 }, encode('Á'));
    assertArrayEquals(new byte[]{ (byte) 194 }, encode('Â'));
    assertArrayEquals(new byte[]{ (byte) 195 }, encode('Ã'));
    //assertArrayEquals(new byte[]{ (byte) 196 }, encode('Ä')); // See 216
    //assertArrayEquals(new byte[]{ (byte) 197 }, encode('É')); // See 220
    //assertArrayEquals(new byte[]{ (byte) 198 }, encode('Æ')); // See 211
    assertArrayEquals(new byte[]{ (byte) 199 }, encode('Ç'));
    assertArrayEquals(new byte[]{ (byte) 200 }, encode('À'));
    //assertArrayEquals(new byte[]{ (byte) 201 }, encode('è')); // See 232
    //assertArrayEquals(new byte[]{ (byte) 202 }, encode('ò')); // See 242
    //assertArrayEquals(new byte[]{ (byte) 203 }, encode('ù')); // See 249
    //assertArrayEquals(new byte[]{ (byte) 204 }, encode('ä')); // See 228
    assertArrayEquals(new byte[]{ (byte) 205 }, encode('Í'));
    //assertArrayEquals(new byte[]{ (byte) 206 }, encode('ö')); // See 246
    //assertArrayEquals(new byte[]{ (byte) 207 }, encode('ü')); // See 252
    //assertArrayEquals(new byte[]{ (byte) 208 }, encode('Å')); // see 212
    assertArrayEquals(new byte[]{ (byte) 209 }, encode('Ñ'));
    assertArrayEquals(new byte[]{ (byte) 210 }, encode('Ø'));
    assertArrayEquals(new byte[]{ (byte) 211 }, encode('Æ'));
    assertArrayEquals(new byte[]{ (byte) 212 }, encode('Å'));
    assertArrayEquals(new byte[]{ (byte) 213 }, encode('Õ'));
    //assertArrayEquals(new byte[]{ (byte) 214 }, encode('ø')); // See 248
    //assertArrayEquals(new byte[]{ (byte) 215 }, encode('æ')); // See 230
    assertArrayEquals(new byte[]{ (byte) 216 }, encode('Ä'));
    //assertArrayEquals(new byte[]{ (byte) 217 }, encode('ì')); // See 236
    assertArrayEquals(new byte[]{ (byte) 218 }, encode('Ö'));
    assertArrayEquals(new byte[]{ (byte) 219 }, encode('Ü'));
    assertArrayEquals(new byte[]{ (byte) 220 }, encode('É'));
    assertArrayEquals(new byte[]{ (byte) 221 }, encode('Ý'));
    assertArrayEquals(new byte[]{ (byte) 222 }, encode('Þ'));
    assertArrayEquals(new byte[]{ (byte) 223 }, encode('ß'));
    assertArrayEquals(new byte[]{ (byte) 224 }, encode('à'));
    assertArrayEquals(new byte[]{ (byte) 225 }, encode('á'));
    assertArrayEquals(new byte[]{ (byte) 226 }, encode('â'));
    assertArrayEquals(new byte[]{ (byte) 227 }, encode('ã'));
    assertArrayEquals(new byte[]{ (byte) 228 }, encode('ä'));
    assertArrayEquals(new byte[]{ (byte) 229 }, encode('å'));
    assertArrayEquals(new byte[]{ (byte) 230 }, encode('æ'));
    assertArrayEquals(new byte[]{ (byte) 231 }, encode('ç'));
    assertArrayEquals(new byte[]{ (byte) 232 }, encode('è'));
    assertArrayEquals(new byte[]{ (byte) 233 }, encode('é'));
    assertArrayEquals(new byte[]{ (byte) 236 }, encode('ì'));
    assertArrayEquals(new byte[]{ (byte) 237 }, encode('í'));
    assertArrayEquals(new byte[]{ (byte) 238 }, encode('î'));
    assertArrayEquals(new byte[]{ (byte) 239 }, encode('ï'));
    assertArrayEquals(new byte[]{ (byte) 240 }, encode('ð'));
    // similar to Eth character
    //assertArrayEquals(new byte[]{ (byte) 68 }, encode('Ð'));
    assertArrayEquals(new byte[]{ (byte) 241 }, encode('ñ'));
    assertArrayEquals(new byte[]{ (byte) 242 }, encode('ò'));
    assertArrayEquals(new byte[]{ (byte) 243 }, encode('ó'));
    assertArrayEquals(new byte[]{ (byte) 244 }, encode('ô'));
    assertArrayEquals(new byte[]{ (byte) 245 }, encode('õ'));
    assertArrayEquals(new byte[]{ (byte) 246 }, encode('ö'));
    assertArrayEquals(new byte[]{ (byte) 247 }, encode('÷'));
    assertArrayEquals(new byte[]{ (byte) 248 }, encode('ø'));
    assertArrayEquals(new byte[]{ (byte) 249 }, encode('ù'));
    assertArrayEquals(new byte[]{ (byte) 250 }, encode('ú'));
    assertArrayEquals(new byte[]{ (byte) 251 }, encode('û'));
    assertArrayEquals(new byte[]{ (byte) 252 }, encode('ü'));
    assertArrayEquals(new byte[]{ (byte) 253 }, encode('ý'));
    assertArrayEquals(new byte[]{ (byte) 254 }, encode('þ'));
    assertArrayEquals(new byte[]{ (byte) 255 }, encode('ÿ'));
  }

  @Test
  public void testDecoding() throws Exception {

    // http://www.unicode.org/Public/MAPPINGS/ETSI/GSM0338.TXT
    // http://en.wikipedia.org/wiki/GSM_03.38
    // http://en.wikipedia.org/wiki/ISO/IEC_8859-1

    assertEquals('\u0000', decode(new byte[]{ (byte) 0 }));
    assertEquals('\u0001', decode(new byte[]{ (byte) 1 }));
    assertEquals('\u0002', decode(new byte[]{ (byte) 2 }));
    assertEquals('\u0003', decode(new byte[]{ (byte) 3 }));
    assertEquals('\u0004', decode(new byte[]{ (byte) 4 }));
    assertEquals('\u0005', decode(new byte[]{ (byte) 5 }));
    assertEquals('\u0006', decode(new byte[]{ (byte) 6 }));
    assertEquals('\u0007', decode(new byte[]{ (byte) 7 }));
    assertEquals('\b', decode(new byte[]{ (byte) 8 }));
    assertEquals('\t', decode(new byte[]{ (byte) 9 }));
    assertEquals('\n', decode(new byte[]{ (byte) 10 }));
    assertEquals('\u000B', decode(new byte[]{ (byte) 11 }));
    assertEquals('\u000C', decode(new byte[]{ (byte) 12 }));
    assertEquals('\r', decode(new byte[]{ (byte) 13 }));
    assertEquals('Δ', decode(new byte[]{ (byte) 16 }));
    assertEquals('\u0011', decode(new byte[]{ (byte) 17 }));
    assertEquals('Φ', decode(new byte[]{ (byte) 18 }));
    assertEquals('Γ', decode(new byte[]{ (byte) 19 }));
    assertEquals('Λ', decode(new byte[]{ (byte) 20 }));
    assertEquals('Ω', decode(new byte[]{ (byte) 21 }));
    assertEquals('Π', decode(new byte[]{ (byte) 22 }));
    assertEquals('Ψ', decode(new byte[]{ (byte) 23 }));
    assertEquals('Σ', decode(new byte[]{ (byte) 24 }));
    assertEquals('θ', decode(new byte[]{ (byte) 25 }));
    assertEquals('Ξ', decode(new byte[]{ (byte) 26 }));
    assertEquals('\u001B', decode(new byte[]{ (byte) 27 }));
    assertEquals('\u001C', decode(new byte[]{ (byte) 28 }));
    assertEquals('\u001D', decode(new byte[]{ (byte) 29 }));
    assertEquals('\u001E', decode(new byte[]{ (byte) 30 }));
    assertEquals('€', decode(new byte[]{ (byte) 31 }));
    assertEquals('\u0020', decode(new byte[]{ (byte) 32 }));
    assertEquals('!', decode(new byte[]{ (byte) 33 }));
    assertEquals('"', decode(new byte[]{ (byte) 34 }));
    assertEquals('#', decode(new byte[]{ (byte) 35 }));
    assertEquals('$', decode(new byte[]{ (byte) 36 }));
    assertEquals('%', decode(new byte[]{ (byte) 37 }));
    assertEquals('&', decode(new byte[]{ (byte) 38 }));
    assertEquals('\'', decode(new byte[]{ (byte) 39 }));
    assertEquals('(', decode(new byte[]{ (byte) 40 }));
    assertEquals(')', decode(new byte[]{ (byte) 41 }));
    assertEquals('*', decode(new byte[]{ (byte) 42 }));
    assertEquals('+', decode(new byte[]{ (byte) 43 }));
    assertEquals(',', decode(new byte[]{ (byte) 44 }));
    assertEquals('-', decode(new byte[]{ (byte) 45 }));
    assertEquals('.', decode(new byte[]{ (byte) 46 }));
    assertEquals('/', decode(new byte[]{ (byte) 47 }));
    assertEquals('0', decode(new byte[]{ (byte) 48 }));
    assertEquals('1', decode(new byte[]{ (byte) 49 }));
    assertEquals('2', decode(new byte[]{ (byte) 50 }));
    assertEquals('6', decode(new byte[]{ (byte) 54 }));
    assertEquals('7', decode(new byte[]{ (byte) 55 }));
    assertEquals('8', decode(new byte[]{ (byte) 56 }));
    assertEquals('9', decode(new byte[]{ (byte) 57 }));
    assertEquals(':', decode(new byte[]{ (byte) 58 }));
    assertEquals(';', decode(new byte[]{ (byte) 59 }));
    assertEquals('<', decode(new byte[]{ (byte) 60 }));
    assertEquals('=', decode(new byte[]{ (byte) 61 }));
    assertEquals('>', decode(new byte[]{ (byte) 62 }));
    assertEquals('?', decode(new byte[]{ (byte) 63 }));
    assertEquals('@', decode(new byte[]{ (byte) 64 }));
    assertEquals('A', decode(new byte[]{ (byte) 65 }));
    assertEquals('B', decode(new byte[]{ (byte) 66 }));
    assertEquals('C', decode(new byte[]{ (byte) 67 }));
    assertEquals('X', decode(new byte[]{ (byte) 88 }));
    assertEquals('Y', decode(new byte[]{ (byte) 89 }));
    assertEquals('Z', decode(new byte[]{ (byte) 90 }));
    assertEquals('[', decode(new byte[]{ (byte) 91 }));
    assertEquals('\\', decode(new byte[]{ (byte) 92 }));
    assertEquals(']', decode(new byte[]{ (byte) 93 }));
    assertEquals('^', decode(new byte[]{ (byte) 94 }));
    assertEquals('_', decode(new byte[]{ (byte) 95 }));
    assertEquals('`', decode(new byte[]{ (byte) 96 }));
    assertEquals('a', decode(new byte[]{ (byte) 97 }));
    assertEquals('b', decode(new byte[]{ (byte) 98 }));
    assertEquals('c', decode(new byte[]{ (byte) 99 }));
    assertEquals('d', decode(new byte[]{ (byte) 100 }));
    assertEquals('x', decode(new byte[]{ (byte) 120 }));
    assertEquals('y', decode(new byte[]{ (byte) 121 }));
    assertEquals('z', decode(new byte[]{ (byte) 122 }));
    assertEquals('{', decode(new byte[]{ (byte) 123 }));
    assertEquals('|', decode(new byte[]{ (byte) 124 }));
    assertEquals('}', decode(new byte[]{ (byte) 125 }));
    assertEquals('~', decode(new byte[]{ (byte) 126 }));
    assertEquals('\u007F', decode(new byte[]{ (byte) 127 }));
    assertEquals('\u0080', decode(new byte[]{ (byte) 128 }));
    assertEquals('\u0081', decode(new byte[]{ (byte) 129 }));
    assertEquals('\u0082', decode(new byte[]{ (byte) 130 }));
    assertEquals('\u0083', decode(new byte[]{ (byte) 131 }));
    assertEquals('\u0084', decode(new byte[]{ (byte) 132 }));
    assertEquals('\u0085', decode(new byte[]{ (byte) 133 }));
    assertEquals('\u0086', decode(new byte[]{ (byte) 134 }));
    assertEquals('\u0087', decode(new byte[]{ (byte) 135 }));
    assertEquals('\u0088', decode(new byte[]{ (byte) 136 }));
    assertEquals('\u0089', decode(new byte[]{ (byte) 137 }));
    assertEquals('\u008A', decode(new byte[]{ (byte) 138 }));
    assertEquals('\u008B', decode(new byte[]{ (byte) 139 }));
    assertEquals('\u008C', decode(new byte[]{ (byte) 140 }));
    assertEquals('\u008D', decode(new byte[]{ (byte) 141 }));
    assertEquals('\u008E', decode(new byte[]{ (byte) 142 }));
    assertEquals('\u008F', decode(new byte[]{ (byte) 143 }));
    assertEquals('\u0090', decode(new byte[]{ (byte) 144 }));
    assertEquals('\u0091', decode(new byte[]{ (byte) 145 }));
    assertEquals('\u0092', decode(new byte[]{ (byte) 146 }));
    assertEquals('\u0093', decode(new byte[]{ (byte) 147 }));
    assertEquals('\u0094', decode(new byte[]{ (byte) 148 }));
    assertEquals('\u0095', decode(new byte[]{ (byte) 149 }));
    assertEquals('\u0096', decode(new byte[]{ (byte) 150 }));
    assertEquals('\u0097', decode(new byte[]{ (byte) 151 }));
    assertEquals('\u0098', decode(new byte[]{ (byte) 152 }));
    assertEquals('\u0099', decode(new byte[]{ (byte) 153 }));
    assertEquals('\u009A', decode(new byte[]{ (byte) 154 }));
    assertEquals('\u009B', decode(new byte[]{ (byte) 155 }));
    assertEquals('\u009C', decode(new byte[]{ (byte) 156 }));
    assertEquals('\u009D', decode(new byte[]{ (byte) 157 }));
    assertEquals('\u009E', decode(new byte[]{ (byte) 158 }));
    assertEquals('\u009F', decode(new byte[]{ (byte) 159 }));
    assertEquals('\u00A0', decode(new byte[]{ (byte) 160 }));
    assertEquals('\u00A1', decode(new byte[]{ (byte) 161 }));
    assertEquals('\u00A2', decode(new byte[]{ (byte) 162 }));
    assertEquals('\u00A3', decode(new byte[]{ (byte) 163 }));
    assertEquals('\u00A4', decode(new byte[]{ (byte) 164 }));
    assertEquals('\u00A5', decode(new byte[]{ (byte) 165 }));
    assertEquals('\u00A6', decode(new byte[]{ (byte) 166 }));
    assertEquals('\u00A7', decode(new byte[]{ (byte) 167 }));
    assertEquals('\u00A8', decode(new byte[]{ (byte) 168 }));
    assertEquals('\u00A9', decode(new byte[]{ (byte) 169 }));
    assertEquals('\u00AA', decode(new byte[]{ (byte) 170 }));
    assertEquals('\u00AB', decode(new byte[]{ (byte) 171 }));
    assertEquals('\u00AC', decode(new byte[]{ (byte) 172 }));
    assertEquals('\u00AD', decode(new byte[]{ (byte) 173 }));
    assertEquals('\u00AE', decode(new byte[]{ (byte) 174 }));
    assertEquals('£', decode(new byte[]{ (byte) 175 }));
    assertEquals('°', decode(new byte[]{ (byte) 176 }));
    assertEquals('±', decode(new byte[]{ (byte) 177 }));
    assertEquals('²', decode(new byte[]{ (byte) 178 }));
    assertEquals('³', decode(new byte[]{ (byte) 179 }));
    assertEquals('ç', decode(new byte[]{ (byte) 180 }));
    assertEquals('µ', decode(new byte[]{ (byte) 181 }));
    assertEquals('Ñ', decode(new byte[]{ (byte) 182 }));
    assertEquals('ñ', decode(new byte[]{ (byte) 183 }));
    assertEquals('¡', decode(new byte[]{ (byte) 184 }));
    assertEquals('¿', decode(new byte[]{ (byte) 185 }));
    assertEquals('¤', decode(new byte[]{ (byte) 186 }));
    assertEquals('»', decode(new byte[]{ (byte) 187 }));
    assertEquals('¥', decode(new byte[]{ (byte) 188 }));
    assertEquals('§', decode(new byte[]{ (byte) 189 }));
    assertEquals('¾', decode(new byte[]{ (byte) 190 }));
    assertEquals('¿', decode(new byte[]{ (byte) 191 }));
    assertEquals('À', decode(new byte[]{ (byte) 192 }));
    assertEquals('Á', decode(new byte[]{ (byte) 193 }));
    assertEquals('Â', decode(new byte[]{ (byte) 194 }));
    assertEquals('Ã', decode(new byte[]{ (byte) 195 }));
    assertEquals('Ä', decode(new byte[]{ (byte) 196 }));
    assertEquals('É', decode(new byte[]{ (byte) 197 }));
    assertEquals('Æ', decode(new byte[]{ (byte) 198 }));
    assertEquals('Ç', decode(new byte[]{ (byte) 199 }));
    assertEquals('À', decode(new byte[]{ (byte) 200 }));
    assertEquals('è', decode(new byte[]{ (byte) 201 }));
    assertEquals('ò', decode(new byte[]{ (byte) 202 }));
    assertEquals('ù', decode(new byte[]{ (byte) 203 }));
    assertEquals('ä', decode(new byte[]{ (byte) 204 }));
    assertEquals('Í', decode(new byte[]{ (byte) 205 }));
    assertEquals('ö', decode(new byte[]{ (byte) 206 }));
    assertEquals('ü', decode(new byte[]{ (byte) 207 }));
    assertEquals('Å', decode(new byte[]{ (byte) 208 }));
    assertEquals('Ñ', decode(new byte[]{ (byte) 209 }));
    assertEquals('Ø', decode(new byte[]{ (byte) 210 }));
    assertEquals('Æ', decode(new byte[]{ (byte) 211 }));
    assertEquals('Å', decode(new byte[]{ (byte) 212 }));
    assertEquals('Õ', decode(new byte[]{ (byte) 213 }));
    assertEquals('ø', decode(new byte[]{ (byte) 214 }));
    assertEquals('æ', decode(new byte[]{ (byte) 215 }));
    assertEquals('Ä', decode(new byte[]{ (byte) 216 }));
    assertEquals('ì', decode(new byte[]{ (byte) 217 }));
    assertEquals('Ö', decode(new byte[]{ (byte) 218 }));
    assertEquals('Ü', decode(new byte[]{ (byte) 219 }));
    assertEquals('É', decode(new byte[]{ (byte) 220 }));
    assertEquals('Ý', decode(new byte[]{ (byte) 221 }));
    assertEquals('Þ', decode(new byte[]{ (byte) 222 }));
    assertEquals('ß', decode(new byte[]{ (byte) 223 }));
    assertEquals('à', decode(new byte[]{ (byte) 224 }));
    assertEquals('á', decode(new byte[]{ (byte) 225 }));
    assertEquals('â', decode(new byte[]{ (byte) 226 }));
    assertEquals('ã', decode(new byte[]{ (byte) 227 }));
    assertEquals('ä', decode(new byte[]{ (byte) 228 }));
    assertEquals('å', decode(new byte[]{ (byte) 229 }));
    assertEquals('æ', decode(new byte[]{ (byte) 230 }));
    assertEquals('\u00E7', decode(new byte[]{ (byte) 231 }));
    assertEquals('è', decode(new byte[]{ (byte) 232 }));
    assertEquals('é', decode(new byte[]{ (byte) 233 }));
    assertEquals('ê', decode(new byte[]{ (byte) 234 }));
    assertEquals('ë', decode(new byte[]{ (byte) 235 }));
    assertEquals('ì', decode(new byte[]{ (byte) 236 }));
    assertEquals('í', decode(new byte[]{ (byte) 237 }));
    assertEquals('î', decode(new byte[]{ (byte) 238 }));
    assertEquals('ï', decode(new byte[]{ (byte) 239 }));
    assertEquals('ð', decode(new byte[]{ (byte) 240 }));
    assertEquals('ñ', decode(new byte[]{ (byte) 241 }));
    assertEquals('ò', decode(new byte[]{ (byte) 242 }));
    assertEquals('ó', decode(new byte[]{ (byte) 243 }));
    assertEquals('ô', decode(new byte[]{ (byte) 244 }));
    assertEquals('õ', decode(new byte[]{ (byte) 245 }));
    assertEquals('ö', decode(new byte[]{ (byte) 246 }));
    assertEquals('÷', decode(new byte[]{ (byte) 247 }));
    assertEquals('ø', decode(new byte[]{ (byte) 248 }));
    assertEquals('ù', decode(new byte[]{ (byte) 249 }));
    assertEquals('ú', decode(new byte[]{ (byte) 250 }));
    assertEquals('û', decode(new byte[]{ (byte) 251 }));
    assertEquals('ü', decode(new byte[]{ (byte) 252 }));
    assertEquals('ý', decode(new byte[]{ (byte) 253 }));
    assertEquals('þ', decode(new byte[]{ (byte) 254 }));
    assertEquals('ÿ', decode(new byte[]{ (byte) 255 }));
  }

  @Test
  public void testAll() throws Exception {
    for (int i = 0; i < 256; i++) {
      char c = decode(new byte[]{ (byte) i });
      byte[] bytes = encode(c);

      Charset iso = StandardCharsets.ISO_8859_1;
      CharsetEncoder isoEncoder = iso.newEncoder();

      try {
        isoEncoder.reset();
        ByteBuffer bb = isoEncoder.encode(CharBuffer.wrap(new char[]{ c }));
      }
      catch (CharacterCodingException e) {
        System.out.println(
            "ISO-8559-1 " + i + " " + c + " " + String.format("%04X", (long) c) + " exception: " + e.getMessage());
      }

      if ((byte) i != bytes[0]) {
        System.out
            .println("[" + String.format("%02X", i) + "] char is " + c + "-" + " => " + String
                .format("%02X", bytes[0]));
      }
    }
  }

//  @Test
//  public void testIndex2() throws Exception {
//    String index2 = ((SmppJinny) charset).getEncoderIndex2();
//    final int index2length = index2.length();
//    int notNull = 0;
//
//    for (int i = 0; i < index2length; i++) {
//      final char c = index2.charAt(i);
//      final char cTest;
//      if (c != '\u0000') {
//        notNull++;
//        byte high = 0x00;
//        switch (i / 256) {
//          case 0:
//            break;
//          case 1:
//            high = 0x03;
//            break;
//          case 2:
//            high = 0x20;
//            break;
//          default:
//            assertTrue("Invalid index " + i, true);
//        }
//        cTest = (char) ((high << 8) + ((long) i & 0xff));
//        byte[] bytes = encode(cTest);
//        char cDecoded = decode(bytes);
//        System.out
//            .println("[" + String.format("%04X", i) + "][" + String.format("%04d", i) + " ] char is " + String
//                .format("\\u%04X", (long) c) + " " + String
//                .format("\\u%04X", (long) cTest) + " => " + cTest + " " + String
//                .format("%02X", bytes[0]) + " => " + cDecoded + " {" + String
//                .format("\\u%04X", (long) cDecoded) + "}");
//        if (cTest != cDecoded) {
//          System.out.println("*******");
//        }
//      }
//    }
//    System.out.println("Not null " + notNull + ", total " + index2length);
//  }

  byte[] encode(char c) {
    try {
      ByteBuffer bb = encoder.encode(CharBuffer.wrap(new char[]{ c }));
      byte[] ba = new byte[bb.limit()];
      bb.get(ba);
      return ba;
    }
    catch (CharacterCodingException e) {
      e.printStackTrace();
    }
    return null;
  }

  char decode(byte[] bytes) {
    try {
      CharBuffer charBuffer = decoder.decode(ByteBuffer.wrap(bytes));
      char[] ca = new char[charBuffer.limit()];
      charBuffer.get(ca);
      assertEquals(1, ca.length);
      return ca[0];
    }
    catch (CharacterCodingException e) {
      e.printStackTrace();
    }
    //assertTrue(false);
    return '\0';
  }
}