with import <nixpkgs> {};
stdenv.mkDerivation {
  name = "exercisms";
  buildInputs = with pkgs; [
  	exercism
		openjdk
		clojure
		leiningen
    go
    python
		ghc
		stack
		hlint
		rustup
		sbcl
		lispPackages.quicklisp
  ];
}
