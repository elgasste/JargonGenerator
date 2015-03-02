package com.shinytoylabs.jargongenerator;

/**
 * Created by s.elgas on 2/26/2015.
 */
public final class JargonLoader {

    public static void LoadJargon(JargonGenerator generator, String type) {
        generator.Reset();

        switch(type.toLowerCase()) {
            case "technical":
                loadTechJargon(generator);
                break;
            case "audio":
                loadAudioJargon(generator);
                break;
            case "excuse":
                loadExcuseJargon(generator);
                break;
            default:
                loadTechJargon(generator);
                break;
        }
    }

    private static void sendDataToGenerator(JargonGenerator generator, String [][] wordPool, String [] constructs) {
        for (int i = 0; i < wordPool.length; i++) {
            for (int j = 0; j < wordPool[i].length; j++) {
                generator.AddWord(wordPool[i][j], i);
            }
        }

        for (int i = 0; i < constructs.length; i++) {
            generator.AddConstruct(constructs[i]);
        }
    }

    private static void loadTechJargon(JargonGenerator generator) {
        String wordPool [][] = {
            { // 0 - abbreviations
                "TCP", "HTTP", "SDD", "RAM", "GB", "CSS", "SSL", "AGP", "SQL", "FTP", "PCI",
                "AI", "ADP", "RSS", "XML", "EXE", "COM", "HDD", "THX", "SMTP", "SMS", "USB", "PNG",
                "PHP", "UDP", "TPS", "RX", "ASCII", "CD-ROM", "CGI", "CPU", "DDR", "DHCP", "BIOS",
                "IDE", "IP", "MAC", "MP3", "AAC", "PPPoE", "SSD", "SDRAM", "VGA", "XHTML", "Y2K", "GUI"
            },
            { // 1 - adjectives
                "auxiliary", "primary", "back-end", "digital", "open-source", "virtual",
                "cross-platform", "redundant", "online", "haptic", "multi-byte", "bluetooth",
                "wireless", "1080p", "neural", "optical", "solid state", "mobile", "unicode",
                "backup", "high speed", "56k", "analog", "fiber optic", "central", "visual", "ethernet"
            },
            { // 2 - nouns
                "driver", "protocol", "bandwidth", "panel", "microchip", "program", "port", "card",
                "array", "interface", "system", "sensor", "firewall", "hard drive", "pixel", "alarm",
                "feed", "monitor", "application", "transmitter", "bus", "circuit", "capacitor", "matrix",
                "address", "form factor", "array", "mainframe", "processor", "antenna", "transistor",
                "virus", "malware", "spyware", "network", "internet"
            },
            { // 3 - verbs
                "back up", "bypass", "hack", "override", "compress", "copy", "navigate", "index",
                "connect", "generate", "quantify", "calculate", "synthesize", "input", "transmit",
                "program", "reboot", "parse", "shut down", "inject", "transcode", "encode",
                "attach", "disconnect", "network"
            },
            { // 4 - verbs ending in "ing"
                "backing up", "bypassing", "hacking", "overriding", "compressing", "copying",
                "navigating", "indexing", "connecting", "generating", "quantifying", "calculating",
                "synthesizing", "inputting", "transmitting", "programming", "rebooting", "parsing",
                "shutting down", "injecting", "transcoding", "encoding", "attaching", "disconnecting",
                "networking"
            }
        };

        String [] constructs = {
            "If we {3} the {2}, we can get to the {0} {2} through the {1} {0} {2}!",
            "We need to {3} the {1} {0} {2}!",
            "Try to {3} the {0} {2}, maybe it will {3} the {1} {2}!",
            "You can't {3} the {2} without {4} the {1} {0} {2}!",
            "Use the {1} {0} {2}, then you can {3} the {1} {2}!",
            "The {0} {2} is down, {3} the {1} {2} so we can {3} the {0} {2}!",
            "{4} the {2} won't do anything, we need to {3} the {1} {0} {2}!",
            "I'll {3} the {1} {0} {2}, that should {3} the {0} {2}!",
            "My {0} {2} is down, our only choice is to {3} and {3} the {1} {2}!",
            "They're inside the {2}, use the {1} {0} {2} to {3} their {2}!",
            "Send the {1} {2} into the {2}, it will {3} the {2} by {4} its {0} {2}!"
        };

        sendDataToGenerator(generator, wordPool, constructs);
    }

    private static void loadAudioJargon(JargonGenerator generator) {
        String wordPool [][] = {
            { // 0 - abbreviations
                "THX", "FLAC", "MP3", "AAC", "48K", "WAV", "DSP", "DAW", "AIFF", "CPS", "AGC",
                "VST", "SPDIF", "M4A", "AC97", "ASIO", "AV", "HDA", "DAI", "APAC", "THD", "VAIO",
                "WMA", "ACPA", "AWAC", "VST3", "CD-ROM", "CD-DA", "AC-3", "RMS", "CBR", "FOH"
            },
            { // 1 - adjectives
                "harmonic", "digital", "analog", "transient", "low-pass", "high-pass", "automated",
                "virtual", "stereo", "mono", "surround", "multi-track", "dynamic", "multi-band",
                "Baxandall", "resonant", "vintage", "peak", "aliased", "auxiliary", "balanced",
                "cardioid", "condenser", "graphic", "master", "unbalanced", "ambient", "phantom"
            },
            { // 2 - nouns
                "gain", "threshold", "plugin", "waveform", "frequency", "amplifier", "filter",
                "soundboard", "mixer", "signal", "exciter", "distortion", "bitrate", "limiter",
                "driver", "channel", "ratio", "sidechain", "latency", "fader", "feedback", "delay",
                "converter", "processor", "ground loop", "impedance", "headroom", "preamp",
                "noise floor", "reverb", "sample", "tone", "transducer"
            },
            { // 3 - verbs
                "boost", "dither", "clip", "mix", "adjust", "cut", "broadcast", "encode",
                "compress", "mix down", "mute", "amplify", "phase-shift", "autotune", "attenuate",
                "EQ", "level", "normalize", "quantize", "shelve", "sweep", "cross-fade", "dial in"
            },
            { // 4 - verbs ending in "ing"
                "boosting", "dithering", "clipping", "mixing", "broadcasting", "encoding",
                "compressing", "mixing down", "muting", "amplifying", "phase-shifting", "autotuning",
                "attenuating", "EQing", "leveling", "normalizing", "quantizing", "shelving", "sweeping",
                "cross-fading", "dialing in"
            }
        };

        String constructs [] = {
            "This {2} has its own {1} {0} {2}, the {1} {2} sounds amazing.",
            "If you {3} the {0} {2}, it's easier to {3} the {0} {2}.",
            "Some people only hear the {1} {2}, but I'm picking up the {0} {1} {2} as well.",
            "They say {1} {0} is the next big thing, but I'm sticking with my {0} {1} {2}.",
            "Ever since {4} the {2} on my {2}, I can totally {3} more {1} {2}s in my {2}.",
            "You should try using the {1} {0} {2}, it will {3} your {1} {2} like you wouldn't believe.",
            "I like to {3} my {1} {1} {2} through my {0} {2}, it's easier to {3} that way.",
            "I've never liked their {1} {2}s, my {1} {0} {2} can {3} so much better.",
            "{4} your {1} {2} will really bring out the {1} {1} {2} when you {3} the {2}.",
            "If you want to {3}, try using the {0} {1} {2}, it's my little trick.",
            "{4} has never been the same since I lost my {1} {1} {2}, now I have to use my {2} for {4}."
        };

        sendDataToGenerator(generator, wordPool, constructs);
    }

    private static void loadExcuseJargon(JargonGenerator generator) {
        String wordPool [][] = {
                { // people/animals
                        "mom", "dad", "brother", "sister", "dog", "cat", "boss", "professor",
                        "roommate", "friend", "colleague", "imaginary friend", "personal space cowboy",
                        "pet alien", "grandma", "grandpa", "ex-professor's former psychiatrist",
                        "personal trainer", "neighbor", "maid", "intern", "mentor", "secretary",
                        "pool boy", "CIA contact", "pet tiger", "son's girlfriend", "butler"
                },
                { // adverbs
                        "accidentally", "purposely", "secretly", "deliberately", "angrily", "spontaneously",
                        "surreptitiously", "furiously", "viciously", "crazily", "subtly", "silently",
                        "loudly", "carelessly", "recklessly", "fatally", "unintentionally", "unwittingly",
                        "knowingly", "explosively", "explicitly", "intentionally", "admittedly", "endlessly"
                },
                { // nouns
                        "homework", "proposal", "report", "project", "poster", "presentation", "deliverable",
                        "assignment", "exam", "research", "disk", "task list", "rough draft", "second draft",
                        "final draft", "paper", "thesis", "model", "program", "notebook", "application",
                        "laptop", "composition"
                },
                { // verbs (in past tense)
                        "ate", "stole", "spilled coffee on", "peed on", "swallowed", "threw away",
                        "tore up", "threw up on", "hid", "buried", "drew on", "buried", "torched",
                        "broke", "sat on", "destroyed", "dropped", "ruined", "puked on", "sold",
                        "blew up", "set fire to", "microwaved", "poured water on", "ripped", "drank"
                },
                { // verbs
                        "deliver", "finish", "complete", "do well on", "type", "contribute to",
                        "print", "submit", "commit to", "work on", "put effort into", "add to",
                        "write", "draw", "continue", "finalize"
                }
        };

        String constructs [] = {
                "My {0} {1} {3} my {2}, so I couldn't {4} my {2}!",
                "I had issues with my {2}, my {0} {3} it, then {1} {3} my {2}!",
                "I couldn't {4} my {2} because my {0} {3} it!",
                "I {1} {3} my {2}, it will be hard to {4} it now.",
                "After my {0} {1} {3} my {2}, I obviously couldn't {4} it.",
                "I had a bad morning, my {0} {1} {3} my {0}'s {2}, then they {3} my {2}.",
                "After my {0} {3} my {2}, I {1} {3} their {2}, so neither of us can {4} it.",
                "I want to {4} my {2}, but my {0} said my {0} {1} {3} it!",
                "My {0} {3} my {2}, because they thought my {0}'s was better.",
                "The thing is, I can't {4} my {2} because my {0} {3} it, probably {1}.",
                "Remember when my {0} {3} my {2}? Well, today they {1} {3} on it too, so I can't {4} it."
        };

        sendDataToGenerator(generator, wordPool, constructs);
    }
}
