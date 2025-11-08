import Image from 'next/image';
import styles from './LodgingCard.module.css';

export default function LodgingCard({ name, description, imageUrl }) {
  return (
    <div className={styles.card}>
      <Image src={imageUrl} alt={name} width={400} height={220} className={styles.image} />
      <div className={styles.content}>
        <h3>{name}</h3>
        <p>{description}</p>
      </div>
    </div>
  );
}