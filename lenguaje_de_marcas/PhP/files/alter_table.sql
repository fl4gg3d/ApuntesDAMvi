-- Afegir les columnes numpersonatges i personatges a la taula d'animes
-- Executa aquest SQL al teu schema on ja existeix la taula animes

ALTER TABLE animes
  ADD COLUMN numpersonatges INT DEFAULT 0,
  ADD COLUMN personatges    TEXT DEFAULT NULL;

-- numpersonatges: enter que compta els personatges afegits
-- personatges:    text que guarda un array JSON, ex: [{"nom":"Goku","ordre":1}, ...]
