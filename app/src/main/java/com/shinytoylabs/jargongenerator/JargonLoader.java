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

        switch(type) {
            case "Technical":
                loadTechJargon(generator);
                break;
            case "Audio":
                loadAudioJargon(generator);
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
            "Send a {adjective} {noun} into the {noun}, it will {verb} the {noun} by {ingverb} its {abbreviation} {noun}"
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
            "{ingverb} your {adjective} {noun} will really bring out the {adjective} {adjective} {noun} when you {verb}.",
            "If you want to {verb}, try using the {abbreviation} {adjective} {noun}, it's my little trick.",
            "{ingverb} has never been the same since I lost my {adjective} {adjective} {noun}, now I have to use my {noun} for {ingverb}."
        };

        sendDataToGenerator(generator, wordPool, constructs);
    }
}
