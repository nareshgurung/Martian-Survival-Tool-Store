package net.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Data
@Table(name="group_contents")
public class Group_contents {
	@Id
	@Column private int group_contents_id;
	@Column private int group_id;
	@Column private int product_id;
	@Column private int group_contents_amount;
	@Column private boolean group_contents_is_visible;
	@Override
	public String toString() {
		return "Group_contents [group_contents_id=" + group_contents_id + ", group_id=" + group_id + ", product_id="
				+ product_id + ", group_contents_amount=" + group_contents_amount + ", group_is_visible="
				+ group_contents_is_visible + "]";
	}
}
