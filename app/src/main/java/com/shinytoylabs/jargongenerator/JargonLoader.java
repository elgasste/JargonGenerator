package com.shinytoylabs.jargongenerator;

/**
 * Created by s.elgas on 2/26/2015.
 */
public final class JargonLoader {

    public enum JargonType {
        TECH, AUDIO
    }

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
        for (int i = 0; i < wordPool[0].length; i++) { generator.AddWord(wordPool[0][i], JargonGenerator.WordType.ABBREVIATION); }
        for (int i = 0; i < wordPool[1].length; i++) { generator.AddWord(wordPool[1][i], JargonGenerator.WordType.ADJECTIVE); }
        for (int i = 0; i < wordPool[2].length; i++) { generator.AddWord(wordPool[2][i], JargonGenerator.WordType.NOUN); }
        for (int i = 0; i < wordPool[3].length; i++) { generator.AddWord(wordPool[3][i], JargonGenerator.WordType.VERB); }
        for (int i = 0; i < wordPool[4].length; i++) { generator.AddWord(wordPool[4][i], JargonGenerator.WordType.INGVERB); }

        for (int i = 0; i < constructs.length; i++) {
            generator.AddConstruct(constructs[i]);
        }
    }

    private static void loadTechJargon(JargonGenerator generator) {
        String wordPool [][] = {
            {
                "TCP", "HTTP", "SDD", "RAM", "GB", "CSS", "SSL", "AGP", "SQL", "FTP", "PCI",
                "AI", "ADP", "RSS", "XML", "EXE", "COM", "HDD", "THX", "SMTP", "SMS", "USB", "PNG",
                "PHP", "UDP", "TPS", "RX", "ASCII", "CD-ROM", "CGI", "CPU", "DDR", "DHCP", "BIOS",
                "IDE", "IP", "MAC", "MP3", "AAC", "PPPoE", "SSD", "SDRAM", "VGA", "XHTML", "Y2K", "GUI"
            },
            {
                "auxiliary", "primary", "back-end", "digital", "open-source", "virtual",
                "cross-platform", "redundant", "online", "haptic", "multi-byte", "bluetooth",
                "wireless", "1080p", "neural", "optical", "solid state", "mobile", "unicode",
                "backup", "high speed", "56k", "analog", "fiber optic", "central", "visual", "ethernet"
            },
            {
                "driver", "protocol", "bandwidth", "panel", "microchip", "program", "port", "card",
                "array", "interface", "system", "sensor", "firewall", "hard drive", "pixel", "alarm",
                "feed", "monitor", "application", "transmitter", "bus", "circuit", "capacitor", "matrix",
                "address", "form factor", "array", "mainframe", "processor", "antenna", "transistor",
                "virus", "malware", "spyware", "network", "internet"
            },
            {
                "back up", "bypass", "hack", "override", "compress", "copy", "navigate", "index",
                "connect", "generate", "quantify", "calculate", "synthesize", "input", "transmit",
                "program", "reboot", "parse", "shut down", "inject", "transcode", "encode",
                "attach", "disconnect", "network"
            },
            {
                "backing up", "bypassing", "hacking", "overriding", "compressing", "copying",
                "navigating", "indexing", "connecting", "generating", "quantifying", "calculating",
                "synthesizing", "inputting", "transmitting", "programming", "rebooting", "parsing",
                "shutting down", "injecting", "transcoding", "encoding", "attaching", "disconnecting",
                "networking"
            }
        };

        String [] constructs = {
            "If we {verb} the {noun}, we can get to the {abbreviation} {noun} through the {adjective} {abbreviation} {noun}!",
            "We need to {verb} the {adjective} {abbreviation} {noun}!",
            "Try to {verb} the {abbreviation} {noun}, maybe it will {verb} the {adjective} {noun}!",
            "You can't {verb} the {noun} without {ingverb} the {adjective} {abbreviation} {noun}!",
            "Use the {adjective} {abbreviation} {noun}, then you can {verb} the {adjective} {noun}!",
            "The {abbreviation} {noun} is down, {verb} the {adjective} {noun} so we can {verb} the {abbreviation} {noun}!",
            "{ingverb} the {noun} won't do anything, we need to {verb} the {adjective} {abbreviation} {noun}!",
            "I'll {verb} the {adjective} {abbreviation} {noun}, that should {verb} the {abbreviation} {noun}!",
            "My {abbreviation} {noun} is down, our only choice is to {verb} and {verb} the {adjective} {noun}!",
            "They're inside the {noun}, use the {adjective} {abbreviation} {noun} to {verb} their {noun}!",
            "Send a {adjective} {noun} into the {noun}, it will {verb} the {noun} by {ingverb} its {abbreviation} {noun}!"
        };

        sendDataToGenerator(generator, wordPool, constructs);
    }

    private static void loadAudioJargon(JargonGenerator generator) {
        String wordPool [][] = {
            {
                "THX", "FLAC", "MP3", "AAC", "48K", "WAV", "DSP", "DAW", "AIFF", "CPS", "AGC",
                "VST", "SPDIF", "M4A", "AC97", "ASIO", "AV", "HDA", "DAI", "APAC", "THD", "VAIO",
                "WMA", "ACPA", "AWAC", "VST3", "CD-ROM", "CD-DA", "AC-3", "RMS", "CBR", "FOH"
            },
            {
                "harmonic", "digital", "analog", "transient", "low-pass", "high-pass", "automated",
                "virtual", "stereo", "mono", "surround", "multi-track", "dynamic", "multi-band",
                "Baxandall", "resonant", "vintage", "peak", "aliased", "auxiliary", "balanced",
                "cardioid", "condenser", "graphic", "master", "unbalanced", "ambient", "phantom"
            },
            {
                "gain", "threshold", "plugin", "waveform", "frequency", "amplifier", "filter",
                "soundboard", "mixer", "signal", "exciter", "distortion", "bitrate", "limiter",
                "driver", "channel", "ratio", "sidechain", "latency", "fader", "feedback", "delay",
                "converter", "processor", "ground loop", "impedance", "headroom", "preamp",
                "noise floor", "reverb", "sample", "tone", "transducer"
            },
            {
                "boost", "dither", "clip", "mix", "adjust", "cut", "broadcast", "encode",
                "compress", "mix down", "mute", "amplify", "phase-shift", "autotune", "attenuate",
                "EQ", "level", "normalize", "quantize", "shelve", "sweep", "cross-fade", "dial in"
            },
            {
                "boosting", "dithering", "clipping", "mixing", "broadcasting", "encoding",
                "compressing", "mixing down", "muting", "amplifying", "phase-shifting", "autotuning",
                "attenuating", "EQing", "leveling", "normalizing", "quantizing", "shelving", "sweeping",
                "cross-fading", "dialing in"
            }
        };

        String constructs [] = {
            "This {noun} has its own {adjective} {abbreviation} {noun}, the {adjective} {noun} sounds amazing.",
            "If you {verb} the {abbreviation} {noun}, it's easier to {verb} the {abbreviation} {noun}.",
            "Some people only hear the {adjective} {noun}, but I'm picking up the {abbreviation} {adjective} {noun} as well.",
            "They say {adjective} {abbreviation} is the next big thing, but I'm sticking with my {abbreviation} {adjective} {noun}.",
            "Ever since {ingverb} the {noun} on my {noun}, I can totally {verb} more {adjective} {noun}s in my {noun}.",
            "You should try using the {adjective} {abbreviation} {noun}, it will {verb} your {adjective} {noun} like you wouldn't believe.",
            "I like to {verb} my {adjective} {adjective} {noun} through my {abbreviation} {noun}, it's easier to {verb} that way.",
            "I've never liked their {adjective} {noun}s, my {adjective} {abbreviation} {noun} can {verb} so much better.",
            "{ingverb} your {adjective} {noun} will really bring out the {adjective} {adjective} {noun} when you {verb} the {noun}.",
            "If you want to {verb}, try using the {abbreviation} {adjective} {noun}, it's my little trick.",
            "{ingverb} has never been the same since I lost my {adjective} {adjective} {noun}, now I have to use my {noun} for {ingverb}."
        };

        sendDataToGenerator(generator, wordPool, constructs);
    }

    private static void loadExcuseJargon(JargonGenerator generator) {
        String wordPool [][] = {
                { // abbreviations (actually people/animals)
                        "mom", "dad", "brother", "sister", "dog", "cat", "boss", "professor",
                        "roommate", "friend", "colleague", "imaginary friend", "personal space cowboy",
                        "pet alien", "grandma", "grandpa", "ex-professor's former psychiatrist",
                        "personal trainer", "neighbor", "maid", "intern", "mentor", "secretary",
                        "pool boy", "CIA contact", "P.I.", "pet tiger", "son's girlfriend"
                },
                { // adjectives (actually adverbs)
                        "accidentally", "purposely", "secretly", "deliberately", "angrily", "spontaneously",
                        "surreptitiously", "furiously", "viciously", "crazily", "subtly", "silently",
                        "loudly", "carelessly", "recklessly", "fatally", "unintentionally", "unwittingly",
                        "knowingly", "explosively", "explicitly", "intentionally", "admittedly"
                },
                { // nouns (actually tasks)
                        "homework", "proposal", "report", "project", "poster", "presentation", "deliverable",
                        "assignment", "exam", "research", "disk", "task list", "rough draft", "second draft",
                        "final draft", "paper", "thesis", "model", "program", "notebook", "application",
                        "laptop", "composition"
                },
                { // verbs (actually verbs in past tense)
                        "ate", "stole", "spilled coffee on", "peed on", "swallowed", "threw away",
                        "tore up", "threw up on", "hid", "buried", "drew on", "buried", "torched",
                        "broke", "sat on", "destroyed", "dropped", "ruined", "puked on", "sold",
                        "blew up", "set fire to", "microwaved", "poured water on", "ripped", "drank"
                },
                { // verbs ending in "ing" (actually regular verbs)
                        "deliver", "finish", "complete", "do well on", "type", "contribute to",
                        "print", "submit", "commit to", "work on", "put effort into", "add to",
                        "write", "draw", "continue"
                }
        };

        String constructs [] = {
                "My {abbreviation} {adjectives} {verb} my {noun}, so I couldn't {ingverb} my {noun}!",
                "I had issues with my {noun}, my {abbreviation} {verb} it, then {adjective} {verb} my {noun}!",
                "I couldn't {ingverb} my {noun} because my {abbreviation} {verb} it!",
                "I {adjective} {verb} my {noun}, it will be hard to {ingverb} it now.",
                "After my {abbreviation} {adjective} {verb} my {noun}, I obviously couldn't {ingverb} it.",
                "I had a bad morning, my {abbreviation} {adjective} {verb} my {abbreviation}'s {noun}, then they {verb} my {noun}.",
                "After my {abbreviation} {verb} my {noun}, I {adjective} {verb} their {noun}, so neither of us can {ingverb} it.",
                "I want to {ingverb} my {noun}, but my {abbreviation} {adjective} made my {abbreviation} {verb} it!",
                "My {abbreviation} {verb} my {noun}, because they thought my {abbreviation}'s was better."
        };

        sendDataToGenerator(generator, wordPool, constructs);
    }
}
