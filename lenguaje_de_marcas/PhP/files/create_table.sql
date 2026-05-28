-- Executar aquest SQL per crear la taula d'usuaris
CREATE TABLE IF NOT EXISTS usuari (
    idUsuari INT AUTO_INCREMENT PRIMARY KEY,
    email    VARCHAR(255) NOT NULL UNIQUE,
    contrasenya VARCHAR(255) NOT NULL
);
