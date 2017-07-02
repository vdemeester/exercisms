let
	_pkgs = import <nixpkgs> {};
in
	{ pkgs ? import (_pkgs.fetchFromGitHub {
		owner = "NixOS";
		repo = "nixpkgs-channels";
		rev = "1add3519dffca4fa40e539904c3c9522582167f7";
		sha256 = "1qmwpvp5s6639qf3llc3yy5qnmdkka7pw1lzr4h73cn2439jg0cn";
	}) {}
}:

pkgs.stdenv.mkDerivation rec {
	name = "exercisms";
	env = pkgs.buildEnv { name = name; paths = buildInputs; };
	buildInputs = [
		pkgs.exercism
		pkgs.go_1_8
	];
}
