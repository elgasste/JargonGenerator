package com.shinytoylabs.jargongenerator;

/**
 * Created by s.elgas on 2/26/2015.
 */
public final class JargonLoader {
    public static void LoadJargon(JargonGenerator jargonGenerator) {
        String wordPool [][] = {
                {"TCP", "HTTP", "SDD", "RAM", "GB", "CSS", "SSL", "AGP", "SQL", "FTP", "PCI",
                        "AI", "ADP", "RSS", "XML", "EXE", "COM", "HDD", "THX", "SMTP", "SMS", "USB", "PNG"},
                {"auxiliary", "primary", "back-end", "digital", "open-source", "virtual",
                        "cross-platform", "redundant", "online", "haptic", "multi-byte", "bluetooth",
                        "wireless", "1080p", "neural", "optical", "solid state", "mobile"},
                {"driver", "protocol", "bandwidth", "panel", "microchip", "program", "port", "card",
                        "array", "interface", "system", "sensor", "firewall", "hard drive", "pixel", "alarm",
                        "feed", "monitor", "application", "transmitter", "bus", "circuit", "capacitor", "matrix"},
                {"back up", "bypass", "hack", "override", "compress", "copy", "navigate", "index",
                        "connect", "generate", "quantify", "calculate", "synthesize", "input", "transmit",
                        "program", "reboot", "parse"},
                {"backing up", "bypassing", "hacking", "overriding", "compressing", "copying",
                        "navigating", "indexing", "connecting", "generating", "quantifying", "calculating",
                        "synthesizing", "transmitting", "programming", "parsing"}
        };

        for (int i = 0; i < wordPool[0].length; i++) { jargonGenerator.AddWord(wordPool[0][i], JargonGenerator.WordType.ABBREVIATION); }
        for (int i = 0; i < wordPool[1].length; i++) { jargonGenerator.AddWord(wordPool[1][i], JargonGenerator.WordType.ADJECTIVE); }
        for (int i = 0; i < wordPool[2].length; i++) { jargonGenerator.AddWord(wordPool[2][i], JargonGenerator.WordType.NOUN); }
        for (int i = 0; i < wordPool[3].length; i++) { jargonGenerator.AddWord(wordPool[3][i], JargonGenerator.WordType.VERB); }
        for (int i = 0; i < wordPool[4].length; i++) { jargonGenerator.AddWord(wordPool[4][i], JargonGenerator.WordType.INGVERB); }

        String [] constructs = {
                "If we {verb} the {noun}, we can get to the {abbreviation} {noun} through the {adjective} {abbreviation} {noun}!",
                "We need to {verb} the {adjective} {abbreviation} {noun}!",
                "Try to {verb} the {abbreviation} {noun}, maybe it will {verb} the {adjective} {noun}!",
                "You can't {verb} the {noun} without {ingverb} the {adjective} {abbreviation} {noun}!",
                "Use the {adjective} {abbreviation} {noun}, then you can {verb} the {adjective} {noun}!",
                "The {abbreviation} {noun} is down, {verb} the {adjective} {noun} so we can {verb} the {abbreviation} {noun}!",
                "{ingverb} the {noun} won't do anything, we need to {verb} the {adjective} {abbreviation} {noun}!",
                "I'll {verb} the {adjective} {abbreviation} {noun}, that should {verb} the {abbreviation} {noun}!"
        };

        for (int i = 0; i < constructs.length; i++) {
            jargonGenerator.AddConstruct(constructs[i]);
        }
    }
}
